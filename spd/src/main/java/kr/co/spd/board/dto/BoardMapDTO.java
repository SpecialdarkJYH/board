package kr.co.spd.board.dto;

import java.util.Date;

public class BoardMapDTO {

	private Integer mapId = null;
	private Integer parMapId = null;
	private String mapNm = null;
	private Integer mapOrder = null;
	private String deleteYn = null;
	private String memoYn = null;
	private Date regDt = null;
	
	public BoardMapDTO() {
		
	}

	public BoardMapDTO(Integer mapId, Integer parMapId, String mapNm, Integer mapOrder, String deleteYn, String memoYn,
			Date regDt) {
		super();
		this.mapId = mapId;
		this.parMapId = parMapId;
		this.mapNm = mapNm;
		this.mapOrder = mapOrder;
		this.deleteYn = deleteYn;
		this.memoYn = memoYn;
		this.regDt = regDt;
	}

	public Integer getMapId() {
		return mapId;
	}

	public void setMapId(Integer mapId) {
		this.mapId = mapId;
	}

	public Integer getParMapId() {
		return parMapId;
	}

	public void setParMapId(Integer parMapId) {
		this.parMapId = parMapId;
	}

	public String getMapNm() {
		return mapNm;
	}

	public void setMapNm(String mapNm) {
		this.mapNm = mapNm;
	}

	public Integer getMapOrder() {
		return mapOrder;
	}

	public void setMapOrder(Integer mapOrder) {
		this.mapOrder = mapOrder;
	}

	public String getDeleteYn() {
		return deleteYn;
	}

	public void setDeleteYn(String deleteYn) {
		this.deleteYn = deleteYn;
	}

	public String getMemoYn() {
		return memoYn;
	}

	public void setMemoYn(String memoYn) {
		this.memoYn = memoYn;
	}

	public Date getRegDt() {
		return regDt;
	}

	public void setRegDt(Date regDt) {
		this.regDt = regDt;
	}

	@Override
	public String toString() {
		return "BoardMapDTO [mapId=" + mapId + ", parMapId=" + parMapId + ", mapNm=" + mapNm + ", mapOrder=" + mapOrder
				+ ", deleteYn=" + deleteYn + ", memoYn=" + memoYn + ", regDt=" + regDt + "]";
	}
	
	
	
}
