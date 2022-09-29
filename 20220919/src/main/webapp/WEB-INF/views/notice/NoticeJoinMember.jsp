<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<div><h1>조인 목록 보기</h1></div>
		<div>
			<c:forEach items="${list}" var="n">
				${n.MEMBER_ID } : ${n.MEMBER_NAME } : ${n.NOTICE_WRITER } : ${n.NOTICE_TITLE }<br> 
				
			</c:forEach>
		</div>
	</div>
</body>
</html>