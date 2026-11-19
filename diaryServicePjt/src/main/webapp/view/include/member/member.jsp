<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

   
<script>

	function signupForm() {
		console.log('signupForm()!')
		
		
		let form = document.signup_form;
		console.log(form);
		
		if(form.memId.value === '') {
			
			alert('마 아이디 입력 와 안 하노!')
			form.memId.focus();
			
		} else if (form.memPw.value === '') {
			
			alert('마 비밀번호 입력 와 안 하노!')
			form.memId.focus();
			
		} else {
			form.submit();
		}
	}


</script>
   