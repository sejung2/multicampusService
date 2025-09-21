<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>
    <b>index 페이지입니다.</b>
</h1>

<P> The time on the server is ${serverTime}. </P>
<a href="${pageContext.request.contextPath}/showInfo"/>showInfo</a>
<a href="${pageContext.request.contextPath}/showInfo2"/>showInfo2</a>
<a href="${pageContext.request.contextPath}/showInfo3"/>showInfo3</a>

<hr>

<a href="${pageContext.request.contextPath}/book/bookInfoView1"/>bookInfoView1</a>
<a href="${pageContext.request.contextPath}/book/bookInfoView2"/>bookInfoView2</a>

<hr>

<h3>학생정보</h3>
<a href="<c:url value='/student/studentForm'/>">studentForm</a>
<a href="<c:url value='/student/studentForm2'/>">학생정보입력2</a>

<hr>

<h3>상품 등록</h3>
<a href="<c:url value='/product/productForm'/>">상품 등록</a>
</body>
</html>
