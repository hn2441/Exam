<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>insert 결과</title>
</head>
<body>
	삽입 완료!<br>
	아이디 : ${dto.id }<br>
	곡이름 : ${dto.name }<br>
	가　격 : ${dto.price }원<br>
	가수명 : ${dto.singer }<br>
	
	<!-- test화면(시작화면)으로 넘어가는 링크 -->
	<a href="test.jsp">선택 화면으로..</a>
</body>
</html>