package kr.co.spd.common.dto;

public class ErrorDTO {

	private int code = 99;
	private String msg = "정상적으로 성공하였습니다.";
	
	public ErrorDTO() {
		
	}	

	public ErrorDTO(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "ErrorDTO [code=" + code + ", msg=" + msg + "]";
	}
	
}

