<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<html>  
<head>
<meta charset="utf-8">
<title>게시판</title> 
<style type="text/css">
	#container{
		margin: 0 auto;
	}
	h2{
		text-align: center;
	}
	
</style>
</head>

<body>

 <c:if test="${id!=null}">
 	<%@include file="loginOk.jsp" %>
 </c:if>
 
 <c:if test="${id==null}">
 	<%@include file="login.jsp" %>
 </c:if>
 
<div id="container">
<h2>글목록(전체 글:${totalCount})</h2>
<table>
  <tr>
    <td align="right" >
       <a href="/bbs/write.bbs">글쓰기</a>
    </td>
  </tr>
</table>

<table border="1"> 
    <tr height="30" > 
      <td align="center"  width="50"  >번 호</td> 
      <td align="center"  width="250" >제   목</td> 
      <td align="center"  width="100" >작성자</td>
      <td align="center"  width="150" >작성일</td> 
      <td align="center"  width="50" >조 회</td>          
    </tr>

   <c:forEach var="article" items="${articleList}">
   <tr height="30">
    <td align="center"  width="50" >
	  <c:out value="${article.articleNum}"/>	   
	</td>
    <td  width="250" >          
      <a href="/bbs/content.bbs?articleNum=${article.articleNum}"> <!-- &pageNum=${pageNum} -->
          ${article.title}
      </a> 
          <c:if test="${article.hit >= 20}">
            <img src="images/image3.png" border="0" height="16">
		  </c:if>
	</td>
    <td align="center"  width="100">${article.id}</td>
    <td align="center"  width="150">${article.writeDate}</td>
    <td align="center"  width="50">${article.hit}</td>
  </tr>
  </c:forEach>
  <tr>	  
      <td colspan="5" align="center" height="40">	 
	  ${pageCode}
	  </td>
  </tr>
</table>
</div>

</body>
</html>