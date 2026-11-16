package com.office.ex.member;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.office.ex.Config;


@WebServlet("*.mem")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberService memberService = new MemberService();
       

    public MemberController() {
        super();
    }

    
    //261116/signup.mem
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());

		
		String nextPage = null;
		
		System.out.println("command: " + command);
		
		switch (command) {
		case MemberConfig.SIGNUP:
			nextPage = generateView("/signup_form");
			
			break;
			
		case MemberConfig.SIGNUP_CONFIRM:
			// memberService = new MemberService();
			
			int resultForSignUp = memberService.signupConfirm(request, response);
			
			if (resultForSignUp == MemberService.SIGN_UP_OK) {
				nextPage = generateView("/signup_ok");
				
			} else {
				nextPage = generateView("/signup_ng");
				
			}
			
			break;
			
		case MemberConfig.SIGNIN:
			nextPage = generateView("/signin_form");
			
			break;
			
		case MemberConfig.SIGNIN_CONFIRM:
			// memberService = new MemberService();
			
			int resultForSignIn = memberService.signinConfirm(request, response);
			
			if (resultForSignIn == MemberService.SIGN_IN_OK) {
				nextPage = generateView("/signin_ok");
				
			} else {
				nextPage = generateView("/signin_ng");
				
			}
			
			break;
			
		case MemberConfig.SIGNOUT :
			
			memberService.signoutConfirm(request, response);
			
			nextPage = request.getContextPath()
					.concat(Config.HOME);
			
			break;
			
		case MemberConfig.MODIFY_FORM :
			
			nextPage = generateView("/modify_form");
			
			int resultForModify = memberService.signupConfirm(request, response);
			
			if (resultForModify == MemberService.MODIFY_OK) {
				nextPage = generateView("/signup_ok");
				
			} else {
				nextPage = generateView("/signup_ng");
				
			}
			
			break;
			
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(nextPage);
		requestDispatcher.forward(request, response);
		
	}
	
	private String generateView (String viewName) {
		
		String view = MemberConfig.VIEW_PREFIX
				.concat(viewName)
				.concat(MemberConfig.VIEW_SURFIX);
		
		return view;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
