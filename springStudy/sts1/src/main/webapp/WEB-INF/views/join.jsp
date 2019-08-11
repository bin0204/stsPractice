<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<title>Insert title here</title>
</head>

<body>

	회원가입화면 만들예정
	<hr />
	${a}, ${b}
	<hr />
	${vo.a}, ${vo.b}, ${vo.c}
	<hr />
	
	<form action="join" method="post" enctype="multipart/form-data">
		아이디<input type="text" name="id" /><br />
		암호<input type="password" name="pw" /><br />
		이름<input type="text" name="name" /><br />
		이미지<input type="file" name="img" /><br />
		<input type="submit" value="회원가입" />
	</form>
	
</body>
</html>