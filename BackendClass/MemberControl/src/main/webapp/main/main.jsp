<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>홈페이지</title>
</head>
<body>
<img src="../img/duke.png"/><br>
<h1>안녕하세요</h1>
<h1>쇼핑몰 중심 JSP 홈페이지 입니다!!!</h1>
<a href="${contextPath}/member/listMembers.do">회원관리<p class="cls2"></p></a>
<a href="${contextPath}/product/listProducts.do">상품관리<p class="cls2"></p></a>
</body>
</html>
