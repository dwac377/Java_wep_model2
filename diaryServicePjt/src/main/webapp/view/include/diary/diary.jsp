<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script>

	function write_confirm = () => {
	
	    console.log("일기 쓰기")
	
	    let form = document.write_confirm;
	    if (form.diayWord.value === '') {
	        alert("일기를 작성하십시오")
	        form.diayWord.focus();
	
	    } else {
	        form.submit();
	    }
	
	}


</script>