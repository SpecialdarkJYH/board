package kr.co.spd.board.dto;

import java.util.Date;

public class BoardFileDTO {
	
	private Integer fileId = null;
	private Date regDt = null;
	private String orgFileNm = null;
	private String newFileNm = null;
	private String ext = null;
	private long fsize = 0;
	private String fpath = null;
	private Integer docId = null;
	
	//fileserver 추가용
	private Integer errorCode = null;
	
	public BoardFileDTO() {
	
	}

	public BoardFileDTO(Integer fileId, Date regDt, String orgFileNm, String newFileNm, String ext, long fsize,
			String fpath, Integer docId, Integer errorCode) {
		super();
		this.fileId = fileId;
		this.regDt = regDt;
		this.orgFileNm = orgFileNm;
		this.newFileNm = newFileNm;
		this.ext = ext;
		this.fsize = fsize;
		this.fpath = fpath;
		this.docId = docId;
		this.errorCode = errorCode;
	}

	public Integer getFileId() {
		return fileId;
	}

	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}

	public Date getRegDt() {
		return regDt;
	}

	public void setRegDt(Date regDt) {
		this.regDt = regDt;
	}

	public String getOrgFileNm() {
		return orgFileNm;
	}

	public void setOrgFileNm(String orgFileNm) {
		this.orgFileNm = orgFileNm;
	}

	public String getNewFileNm() {
		return newFileNm;
	}

	public void setNewFileNm(String newFileNm) {
		this.newFileNm = newFileNm;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public long getFsize() {
		return fsize;
	}

	public void setFsize(long fsize) {
		this.fsize = fsize;
	}

	public String getFpath() {
		return fpath;
	}

	public void setFpath(String fpath) {
		this.fpath = fpath;
	}

	public Integer getDocId() {
		return docId;
	}

	public void setDocId(Integer docId) {
		this.docId = docId;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	@Override
	public String toString() {
		return "BoardFileDTO [fileId=" + fileId + ", regDt=" + regDt + ", orgFileNm=" + orgFileNm + ", newFileNm="
				+ newFileNm + ", ext=" + ext + ", fsize=" + fsize + ", fpath=" + fpath + ", docId=" + docId
				+ ", errorCode=" + errorCode + "]";
	}
	
}
