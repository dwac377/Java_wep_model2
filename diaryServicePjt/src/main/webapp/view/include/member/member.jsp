<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

   
<script>

	function signup_confirm() {
		console.log('signupForm()!')
		
		
		let form = document.signup_form;
		console.log(form);
		
		if(form.memId.value === '') {
			
			alert('마 아이디 입력 와 안 하노!')
			form.memId.focus();
			
		} else if (form.memPw.value === '') {
			
			alert('마 비밀번호 입력 와 안 하노!')
			form.memPw.focus();
			
		} else {
			form.submit();
		}

	}

	function signin_confirm() {

		console.log("ssss")

		let form = document.signin_form;
		console.log(form);
		
		if(form.memId.value === '') {
			
			alert('마 아이디 입력 와 안 하노!')
			form.memId.focus();
			
		} else if (form.memPw.value === '') {
			
			alert('마 비밀번호 입력 와 안 하노!')
			form.memPw.focus();
			
		} else {
			form.submit();
		}


	}


</script>
   