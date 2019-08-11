<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta charset="utf-8">
<title>글읽기</title>

<style type="text/css">
table {
	width: 900px;
	border: 1px solid;
}

table tr td {
	border: 1px solid;
}

#container {
	margin: 0 auto;
	width: 900px;
}
</style>

</head>
<body>

	<form action="/bbs/replyForm.bbs" method="post">
		<div id="container">
			<table>
				<tr>
					<td>글쓴이 :</td>
					<td>${article.id}</td>
					<td>조회수 :</td>
					<td>${article.hit}</td>
				</tr>
				<tr>
					<td>제목 :</td>
					<td>${article.title}</td>
					<td>날짜 :</td>
					<td>${article.writeDate}</td>
				</tr>
				<tr>
					<td colspan="4">${article.content}</td>
				</tr>
				<tr>
					<td colspan="2">다운로드</td>
					<td colspan="2"></td>
				</tr>
				<tr>
					<c:if test="${id !=null}">
						<td colspan="4" align="right">
							<input type="submit" value="답글달기">
							 <c:if test="${id ==article.id}">
								<input type="button" value="수정하기"
									onclick="document.location.href='/bbs/update.bbs?articleNum=${article.articleNum}&pageNum=${pageNum}'">
								<input type="button" value="삭제하기"
									onclick="document.location.href='/bbs/delete.bbs?articleNum=${article.articleNum}&pageNum=${pageNum}'">
							</c:if>
							<c:if test="${id !=article.id}">
								<input type="button" value="수정하기" disabled="disabled">
								<input type="button" value="삭제하기" disabled="disabled">
							</c:if> <input type="button" value="목록으로"
							onclick="document.location.href='/bbs/list.bbs?pageNum=${pageNum}'">
						</td>
					</c:if>

					<c:if test="${id ==null}">
						<td colspan="4" align="right"><input type="submit"
							value="답글달기" disabled="disabled"> <input type="button"
							value="수정하기" disabled="disabled"> <input type="button"
							value="삭제하기" disabled="disabled"> <input type="button"
							value="목록으로"
							onclick="document.location.href='/bbs/list.bbs?pageNum=${pageNum}'">
						</td>
					</c:if>
				</tr>
				<tr>
					<td colspan="4"><textarea rows="5" cols="70"
							id="commentContent"></textarea><br>
					<br> <c:if test="${id ==null}">
							<input type="button" value="comment 쓰기" disabled="disabled">
						</c:if> <c:if test="${id !=null}">
							<input type="button" value="comment 쓰기" id="commentWrite">
						</c:if> <input type="button" value="comment 읽기()"
						onclick="getComment(1,event)" id="commentRead"></td>
				</tr>
			</table>
		</div>
	</form>

	<div>
		<div id="showComment" align="center"></div>
		<input type="hidden" id="commPageNum" value="1">
	</div>



</body>
</html>