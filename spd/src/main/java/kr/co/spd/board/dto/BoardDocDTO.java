package kr.co.spd.board.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class BoardDocDTO {
	
	private Integer docId = null;
	private Integer mapId = null;
	private Integer userId = null;
	private Date regDt = null;
	private String title = null;
	private Integer hit = null;
	private String docContents = null;
	
	//join sql로 댓글 이름 가져오기
	private String name = null;
	
	//파일 추가
	private List<MultipartFile> files = new ArrayList<MultipartFile>(); 
	
	//파일 부르기
	private List<BoardFileDTO> fList = new ArrayList<BoardFileDTO>();
	
	//MAP_NM
	private String mapNm = null;

	//첨부파일 가져오기 용 관계있는 boardmap
	private BoardMapDTO boardMapDTO = null;
	
	//수정시 파일 삭제 
	private List<Integer> delFileList = new ArrayList<Integer>();
	
	//댓글 갯수 null일수는 없다 0개를 해도
	private Integer count = 0;
	
	// list뒤에 null 이 기본값이라서 파일을 삭제 안하면 수정이 안된다.
	// 그래서 뒤에 추가하는데 파일부르기와 수정시 파일삭제중 다 해야하는건진 테스트해보기
	

	public BoardDocDTO() {
		
	}

	public BoardDocDTO(Integer docId, Integer mapId, Integer userId, Date regDt, String title, Integer hit,
			String docContents, String name, List<MultipartFile> files, List<BoardFileDTO> fList, String mapNm,
			BoardMapDTO boardMapDTO, List<Integer> delFileList, Integer count) {
		super();
		this.docId = docId;
		this.mapId = mapId;
		this.userId = userId;
		this.regDt = regDt;
		this.title = title;
		this.hit = hit;
		this.docContents = docContents;
		this.name = name;
		this.files = files;
		this.fList = fList;
		this.mapNm = mapNm;
		this.boardMapDTO = boardMapDTO;
		this.delFileList = delFileList;
		this.count = count;
	}

	public Integer getDocId() {
		return docId;
	}

	public void setDocId(Integer docId) {
		this.docId = docId;
	}

	public Integer getMapId() {
		return mapId;
	}

	public void setMapId(Integer mapId) {
		this.mapId = mapId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getRegDt() {
		return regDt;
	}

	public void setRegDt(Date regDt) {
		this.regDt = regDt;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getHit() {
		return hit;
	}

	public void setHit(Integer hit) {
		this.hit = hit;
	}

	public String getDocContents() {
		return docContents;
	}

	public void setDocContents(String docContents) {
		this.docContents = docContents;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<MultipartFile> getFiles() {
		return files;
	}

	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}

	public List<BoardFileDTO> getfList() {
		return fList;
	}

	public void setfList(List<BoardFileDTO> fList) {
		this.fList = fList;
	}

	public String getMapNm() {
		return mapNm;
	}

	public void setMapNm(String mapNm) {
		this.mapNm = mapNm;
	}

	public BoardMapDTO getBoardMapDTO() {
		return boardMapDTO;
	}

	public void setBoardMapDTO(BoardMapDTO boardMapDTO) {
		this.boardMapDTO = boardMapDTO;
	}

	public List<Integer> getDelFileList() {
		return delFileList;
	}

	public void setDelFileList(List<Integer> delFileList) {
		this.delFileList = delFileList;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "BoardDocDTO [docId=" + docId + ", mapId=" + mapId + ", userId=" + userId + ", regDt=" + regDt
				+ ", title=" + title + ", hit=" + hit + ", docContents=" + docContents + ", name=" + name + ", files="
				+ files + ", fList=" + fList + ", mapNm=" + mapNm + ", boardMapDTO=" + boardMapDTO + ", delFileList="
				+ delFileList + ", count=" + count + "]";
	}
	

}
