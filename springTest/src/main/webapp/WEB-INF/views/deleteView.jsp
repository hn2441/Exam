<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>delete 결과</title>
</head>
<body>
	<!-- 삭제 결과를 띄워주는 페이지 -->
	아이디 : ${dto.id }<br>
	곡이름 : ${dto.name }<br>
	가　격 : ${dto.price }원<br>
	가수명 : ${dto.singer }<br>
	
	삭제되었습니다!
	<!-- test화면(시작화면)으로 넘어가는 링크 -->
	<a href="test.jsp">선택 화면으로..</a>
</body>
</html>