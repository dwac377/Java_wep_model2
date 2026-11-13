package com.office.member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberService {
	
	MemberDao memberDao = new MemberDao();

	public int logupConfirm(HttpServletRequest request, HttpServletResponse response) {
		
		int res = memberDao.insertMemberInfo();
		
		return 0;
	}



}
