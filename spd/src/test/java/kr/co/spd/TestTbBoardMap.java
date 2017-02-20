package kr.co.spd;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.spd.board.dto.BoardMapDTO;
import kr.co.spd.board.service.IBoardMapService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={
  "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
  "file:src/main/webapp/WEB-INF/spring/root-context.xml"}
)
public class TestTbBoardMap {
	
	private static final Logger logger = LoggerFactory.getLogger(TestTbUser.class);

	@Autowired private IBoardMapService boardMapServiceImpl = null;
	
	@Test
	public void write() {

		BoardMapDTO bmDTO = new BoardMapDTO();
		
		bmDTO.setMapNm("myBatis");
		bmDTO.setMapOrder(4);
		bmDTO.setParMapId(43);
		bmDTO.setDeleteYn("N");
		bmDTO.setMemoYn("N");
		
		boardMapServiceImpl.write(bmDTO);
		
	}
	
	@Test
	public void edit() {
		
		BoardMapDTO bmDTO = new BoardMapDTO();
		
		bmDTO.setMapNm("자유게시판수정");
		bmDTO.setMapOrder(1);
		bmDTO.setDeleteYn("N");
		bmDTO.setMemoYn("N");

		bmDTO.setMapId(21);
		
		boardMapServiceImpl.edit(bmDTO);
	}
	
	@Test
	public void view() {
		
		Integer mapId = 21;
		BoardMapDTO bmDTO = boardMapServiceImpl.view(mapId);
		logger.debug("===>view   " + mapId );
		logger.debug("===>view   " + bmDTO );
		
	}
	
	@Test
	public void delete() {
		
		Integer mapId = 1;
		boardMapServiceImpl.remove(mapId);
		logger.debug("===>delete lgn_id  " + mapId );
		
	}

	@Test
	public void list() {
		
		List<BoardMapDTO> list = boardMapServiceImpl.list();
		
		for (BoardMapDTO obj : list) {
			
			logger.debug("===>list" + obj);
		}
		
	}
	
	
}
