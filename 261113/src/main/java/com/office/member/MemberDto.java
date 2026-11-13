package com.office.member;

public class MemberDto {
	
	private String memId;
	private String memPw;
	
	
	public MemberDto(String memId, String memPw) {
		this.memId = memId;
		this.memPw = memPw;
	}
	
	public MemberDto() {
		// TODO Auto-generated constructor stub
	}
	
//	---------- 게터 & 세터

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemPw() {
		return memPw;
	}

	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}
	
	
	
	

}
