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

	ȸ������ȭ�� ���鿹��
	<hr />
	${a}, ${b}
	<hr />
	${vo.a}, ${vo.b}, ${vo.c}
	<hr />
	
	<form action="join" method="post" enctype="multipart/form-data">
		���̵�<input type="text" name="id" /><br />
		��ȣ<input type="password" name="pw" /><br />
		�̸�<input type="text" name="name" /><br />
		�̹���<input type="file" name="img" /><br />
		<input type="submit" value="ȸ������" />
	</form>
	
</body>
</html>