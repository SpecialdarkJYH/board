package kr.co.spd.user.dto;

import java.io.Serializable;
import java.util.Date;

public class UserDTO implements Serializable{

	/**
	 * Serializable ctrl +1 -> general 뭐시기
	 */
	private static final long serialVersionUID = -4356401122020322360L;
	
	private Integer userId = null;
	private String lgnId = null;
	private String lgnPw = null;
	private String email = null;
	private String phone = null;
	private String name = null;
	private Date regDt = null;
	private Integer status = null;
	
	private String role = "USER";
	
	public UserDTO() {

	}

	public UserDTO(Integer userId, String lgnId, String lgnPw, String email, String phone, String name, Date regDt,
			Integer status) {
		super();
		this.userId = userId;
		this.lgnId = lgnId;
		this.lgnPw = lgnPw;
		this.email = email;
		this.phone = phone;
		this.name = name;
		this.regDt = regDt;
		this.status = status;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getLgnId() {
		return lgnId;
	}

	public void setLgnId(String lgnId) {
		this.lgnId = lgnId;
	}

	public String getLgnPw() {
		return lgnPw;
	}

	public void setLgnPw(String lgnPw) {
		this.lgnPw = lgnPw;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRegDt() {
		return regDt;
	}

	public void setRegDt(Date regDt) {
		this.regDt = regDt;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", lgnId=" + lgnId + ", lgnPw=" + lgnPw + ", email=" + email + ", phone="
				+ phone + ", name=" + name + ", regDt=" + regDt + ", status=" + status + "]";
	}
	
	

}
