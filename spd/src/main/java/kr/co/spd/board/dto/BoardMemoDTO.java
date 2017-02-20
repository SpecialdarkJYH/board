package kr.co.spd.board.dto;

import java.util.Date;

public class BoardMemoDTO {
	
	private Integer memoId = null;
	private Date regDt = null;
	private String memoContents = null;
	private Integer docId = null;
	private Integer userId = null;
	private String name = null;
	
	public BoardMemoDTO() {
		
	}

	public BoardMemoDTO(Integer memoId, Date regDt, String memoContents, Integer docId, Integer userId, String name) {
		super();
		this.memoId = memoId;
		this.regDt = regDt;
		this.memoContents = memoContents;
		this.docId = docId;
		this.userId = userId;
		this.name = name;
	}

	public Integer getMemoId() {
		return memoId;
	}

	public void setMemoId(Integer memoId) {
		this.memoId = memoId;
	}

	public Date getRegDt() {
		return regDt;
	}

	public void setRegDt(Date regDt) {
		this.regDt = regDt;
	}

	public String getMemoContents() {
		return memoContents;
	}

	public void setMemoContents(String memoContents) {
		this.memoContents = memoContents;
	}

	public Integer getDocId() {
		return docId;
	}

	public void setDocId(Integer docId) {
		this.docId = docId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "BoardMemoDTO [memoId=" + memoId + ", regDt=" + regDt + ", memoContents=" + memoContents + ", docId="
				+ docId + ", userId=" + userId + ", name=" + name + "]";
	}

}
