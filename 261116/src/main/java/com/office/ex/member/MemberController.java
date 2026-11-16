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
       

    public MemberController() {
        super();
    }

    
    //261116/signup.mem
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());

		MemberService memberService = new MemberService();
		String nextPage = null;
		
		System.out.println("command: " + command);
		
		switch (command) {
		case "/signup.mem":
			nextPage = generateView("/signup_form");
			
			break;
			
		case "/signup_confirm.mem":
			// memberService = new MemberService();
			
			int resultForSignUp = memberService.signupConfirm(request, response);
			
			if (resultForSignUp == MemberService.SIGN_UP_OK) {
				nextPage = generateView("/signup_ok");
				
			} else {
				nextPage = generateView("/signup_ng");
				
			}
			
			break;
			
		case "/signin.mem":
			nextPage = generateView("/signin_form");
			
			break;
			
		case "/signin_confirm.mem":
			// memberService = new MemberService();
			
			int resultForSignIn = memberService.signinConfirm(request, response);
			
			if (resultForSignIn == MemberService.SIGN_IN_OK) {
				nextPage = generateView("/signin_ok");
				
			} else {
				nextPage = generateView("/signin_ng");
				
			}
			
			break;
			
		case "/signout.mem" :
			
			memberService.signoutConfirm(request, response);
			
			nextPage = request.getContextPath()
					.concat(Config.HOME);
			
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
