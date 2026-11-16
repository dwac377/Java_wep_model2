<%@page import="com.office.ex.member.MemberConfig"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.office.ex.Config"%>


  	<%
  		Object object = session.getAttribute(Config.SIGNINED_MEMBER);
  		
  		if (object != null) {
  	%>		
  			<a href=<%= request.getContextPath().concat(Config.HOME) %>>HOME</a>
  			<a href=<%= request.getContextPath().concat(MemberConfig.SIGN_OUT) %>>sign-out</a>
			&nbsp;&nbsp; | &nbsp;&nbsp;
			<a href=<%= request.getContextPath().concat(MemberConfig.MODIFY) %>>modify</a>
			&nbsp;&nbsp; | &nbsp;&nbsp;
			<a href=<%= request.getContextPath().concat(MemberConfig.DELETE) %>>delete</a>
  			
  			
  	<%	
  		} else {
  	%>
  			<a href="<%= request.getContextPath() %>/">home</a>
			&nbsp;&nbsp; | &nbsp;&nbsp;
			<a href="<%= request.getContextPath() %>/signup.mem">sign-up</a>
			&nbsp;&nbsp; | &nbsp;&nbsp;
			<a href="<%= request.getContextPath() %>/signin.mem">sign-in</a>
  			
  		
  	<%	
  		}
  	%>
