<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>파일 업로드 결과</title>
</head>
<body>
다음의 파일을 업로드 하였습니다.<br>

<c:forEach items="${originalFileNameList}" var="file">
    ${file} <br>
</c:forEach>

<a href="<c:url value='/'/> "> 홈으로 이동</a>
</body>
</html>
