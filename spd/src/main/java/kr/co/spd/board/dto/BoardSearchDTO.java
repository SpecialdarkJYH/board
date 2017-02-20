package kr.co.spd.board.dto;

import kr.co.spd.common.dto.PageDTO;

public class BoardSearchDTO extends PageDTO{
	
	private Integer userId = null;
	private Integer mapId = null;
	private Integer mapNm = null;
	private String searchText = null;
	private String searchType = null;
	
	public BoardSearchDTO() {
		
	}
	
	public BoardSearchDTO(Integer userId, Integer mapId, Integer mapNm, String searchText, String searchType) {
		super();
		this.userId = userId;
		this.mapId = mapId;
		this.mapNm = mapNm;
		this.searchText = searchText;
		this.searchType = searchType;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getMapId() {
		return mapId;
	}

	public void setMapId(Integer mapId) {
		this.mapId = mapId;
	}

	public Integer getMapNm() {
		return mapNm;
	}

	public void setMapNm(Integer mapNm) {
		this.mapNm = mapNm;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	@Override
	public String toString() {
		return "BoardSearchDTO [userId=" + userId + ", mapId=" + mapId + ", mapNm=" + mapNm + ", searchText="
				+ searchText + ", searchType=" + searchType + "]";
	}
	
}
