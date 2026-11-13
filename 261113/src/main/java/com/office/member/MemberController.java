package com.office.member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("*.mem")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MemberController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String RequstURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequstURI.substring(contextPath.length());
		
		MemberService memberService = null;
		String nextPage = null;
		
		switch (command) {
		
		case "logup.mem":
			nextPage = "view/member/logup_ok.jsp";
			
			break;
			
		case "logup_confirm.mem":
			memberService = new MemberService();
			
			int resultForLogUp = memberService.logupConfirm(request, response);
			
			
		
		
		
		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
