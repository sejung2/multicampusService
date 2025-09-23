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
<a href="<c:url value='/student/studentForm'/>">학생정보입력(정적경로)</a> <br>
<a href="<c:url value='/student/studentForm2'/>">학생정보입력2(동적경로)</a> <br>
<a href="<c:url value='/student/studentForm3'/>">학생정보입력3(command 객체 사용)</a> <br>
<a href="<c:url value='/student/studentForm4'/>">학생정보입력4(command 객체 사용 + @ModelAttribute 사용</a> <br>
<a href="<c:url value='/student/studentForm5'/>">학생정보입력5(Date 타입 정보를 전달)</a>
<a href="<c:url value='/student/studentSearchForm'/>">학생정보검색(여러개의 정보 HashMap에 저장)</a>

<hr>

<h3>상품 등록</h3>
<a href="<c:url value='/product/productForm'/>">상품 등록</a>
<a href="<c:url value='/product/productForm3'/>">상품 등록3</a>
<a href="<c:url value='/product/productForm4'/>">상품 등록4</a>
<a href="<c:url value='/product/productSearchForm'/>">상품 정보검색</a>

<h3>redirect</h3>
<a href="<c:url value='/redirect'/>">redirect</a>
<a href="<c:url value='/redirectParam1'/>">redirect-쿼리스트링</a>
<a href="<c:url value='/redirectParam2'/>">redirect-모델객체에추가</a>
<a href="<c:url value='/redirectParam3'/>">redirect-리다이렉트 속성 객체에 추가</a>
</body>
</html>
