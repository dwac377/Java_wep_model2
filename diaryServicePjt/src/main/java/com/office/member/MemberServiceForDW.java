package com.office.member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MemberServiceForDW implements IMemberService{
	
	final private IMemberDao memberDao;

	
	public MemberServiceForDW(IMemberDao iMemberDao) {
		this.memberDao = iMemberDao;
	}

	@Override
	public int signup(HttpServletRequest request, HttpServletResponse response) {
		
		String memId = request.getParameter("memId");
		String memPw = request.getParameter("memPw");
		String memMail = request.getParameter("memMail");
		String memPhone = request.getParameter("memPhone");
		
		MemberDto memberDto = new MemberDto(memId, memPw, memMail, memPhone);
		boolean isMember = memberDao.isMember(memId);
		int result = 0;
		
		if(!isMember) {
			
			result = memberDao.insertNewMember(memberDto);
		}
		return result;
	}

	@Override
	public MemberDto signin(HttpServletRequest request, HttpServletResponse response) {
		
		String memId = request.getParameter("memId");
		String memPw = request.getParameter("memPw");
		
		MemberDto selectedMembeDto = memberDao.selectMemberByMemId(memId);
		
		if (selectedMembeDto != null) {
			
			System.out.println("[MemberService] seletedMemberDto is not null");
			if (selectedMembeDto.getMemPw().equals(memPw)) {
				System.out.println("로그인 성공");
				
				return selectedMembeDto;
			} else {
				System.out.println("로그인 실패데쓰");
				
				return null;
			} 
			
			
		} else {
			System.out.println("[MemberService] seletedMemberDto is null");
			System.out.println("로그인 실패데쓰");
			
			return null;
		}
		
	}
	
	

}
