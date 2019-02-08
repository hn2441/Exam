<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>insert</title>
</head>
<body>
	<!-- 입력하는 폼 : id는 자동생성됨. 
	노래명, 가격, 가수명만 입력받아서 넘겨주는 폼 -->
	<form action="insert"><table>
		<tr>
			<td>아이디 :</td>
			<td><input type="text" value="자동생성" readonly="readonly" 
				style="width: 200px"></td>
		</tr>
		<tr>
			<td>노래명 :</td>
			<td><input type="text" id="name" name="name"
				 style="width: 200px"></td>
		</tr>
		<tr>
			<td>가 격 :</td>
			<td><input type="number" id="price" name="price"
				 style="width: 180px">원</td>
		</tr>
		<tr>
			<td>가수명 :</td>
			<td><input type="text" id="singer" name="singer"
				 style="width: 200px"></td>
		</tr>
		<tr><td colspan="2"><input type="submit" value="입력"></td></tr>
	</table></form>
	<!-- test화면(시작화면)으로 넘어가는 링크 -->
	<a href="test.jsp">선택 화면으로..</a>
</body>
</html>