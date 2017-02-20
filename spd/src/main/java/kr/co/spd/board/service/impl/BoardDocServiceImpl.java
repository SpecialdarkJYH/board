package kr.co.spd.board.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import kr.co.spd.board.dao.IBoardDocDAO;
import kr.co.spd.board.dao.IBoardFileDAO;
import kr.co.spd.board.dao.IBoardMemoDAO;
import kr.co.spd.board.dto.BoardDocDTO;
import kr.co.spd.board.dto.BoardFileDTO;
import kr.co.spd.board.dto.BoardSearchDTO;
import kr.co.spd.board.service.IBoardDocService;
import kr.co.spd.board.service.IBoardMapService;
import kr.co.spd.board.service.IBoardMemoService;
import kr.co.spd.common.file.FileService;

@Service
public class BoardDocServiceImpl implements IBoardDocService {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardDocServiceImpl.class);
	
	@Autowired private IBoardDocDAO boardDocDAOImpl = null;
	@Autowired private IBoardFileDAO boardFileDAOImpl = null;
	@Autowired private FileService fileService = null;
	
	@Autowired private IBoardMapService boardMapServiceImpl = null;
	@Autowired private IBoardMemoService boardMemoServiceImpl = null;
	
	@Autowired private IBoardMemoDAO boardMemoDAOImpl = null;

	@Override
	@Transactional
	public void write(BoardDocDTO _boardDocDTO, HttpSession httpSession) {
		
		//1. 게시물 insert
		boardDocDAOImpl.insert(_boardDocDTO);
		
		/*Transaction test용
		String aa = null;
		aa.toCharArray();*/
		
		//2. 첨부파일 insert
		for(MultipartFile file : _boardDocDTO.getFiles()) {
			
			BoardFileDTO bfDTO = fileService.uploadSingleFile(file, httpSession);
			
			bfDTO.setDocId(_boardDocDTO.getDocId());
			boardFileDAOImpl.insert(bfDTO);
			logger.debug("=====> bfDTO" +bfDTO );
		}
		
	}

	@Override
	@Transactional
	public void edit(BoardDocDTO _boardDocDTO, HttpSession httpSession) {
		
		//1. 첨부파일 삭제
		for(Integer fileId : _boardDocDTO.getDelFileList()) {
			
			logger.debug("=============> fileId" + fileId);
			boardFileDAOImpl.delete(fileId);
		}
		
		//2. 첨부파일 추가
		for(MultipartFile file : _boardDocDTO.getFiles()) {
			
			BoardFileDTO bfDTO = fileService.uploadSingleFile(file, httpSession);
			
			bfDTO.setDocId(_boardDocDTO.getDocId());
			boardFileDAOImpl.insert(bfDTO);
			
			logger.debug("=====> bfDTO" +bfDTO );
		}
		
		//3. 게시물 수정
		boardDocDAOImpl.update(_boardDocDTO);
		
	}

	@Override
	public BoardDocDTO view(Integer _docId) {
		
		//조회수 증가
		boardDocDAOImpl.cntHit(_docId);
		
		//게시물 정보
		BoardDocDTO bdDTO = boardDocDAOImpl.selectOne(_docId);
		
		/*//맵정보 가져오기 일관성있게 컨트롤러로 가져감
		BoardMapDTO bmDTO = boardMapServiceImpl.view(bdDTO.getMapId());
		bdDTO.setBoardMapDTO(bmDTO);*/
		
		//첨부파일 가져오기
		List<BoardFileDTO> fList = boardFileDAOImpl.selectList(_docId);
		bdDTO.setfList(fList);
		
		//댓글 가져오기(ajax로 처리)
		
		return bdDTO;
	}

	@Override
	@Transactional
	public void remove(BoardDocDTO _boardDocDTO) {
		
		//1. 댓글 삭제
		boardMemoDAOImpl.deleteByDocId(_boardDocDTO.getDocId());
		//2. 첨부파일 삭제
		boardFileDAOImpl.deleteByDocId(_boardDocDTO.getDocId());
		//3.게시글 삭제
		boardDocDAOImpl.delete(_boardDocDTO);
	}

	@Override
	public List<BoardDocDTO> list(BoardSearchDTO _search) {
		
		// 1. 전체 게시물 갯수 가져오기
		int cnt = boardDocDAOImpl.selectCount(_search);
		_search.setTotal(cnt);
		/*_search.setRows(3);*/
		
		// 2. 게시물 목록 가져오기
		List<BoardDocDTO> list = boardDocDAOImpl.selectList(_search);
		
		//첨부파일 가져오기
		for(BoardDocDTO _boardDocDTO : list) {
			
			List<BoardFileDTO> fList = boardFileDAOImpl.selectList(_boardDocDTO.getDocId());
			_boardDocDTO.setfList(fList);
			
		}
		
		return list;
		
	}

}
