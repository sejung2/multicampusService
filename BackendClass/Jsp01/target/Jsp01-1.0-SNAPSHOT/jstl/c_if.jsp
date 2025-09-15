<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--변수 선언--%>
<c:set var="id" value="hong" scope="page"/>
<c:set var="pwd" value="1234" scope="page"/>
<c:set var="name" value="${'홍길동'}" scope="page"/>
<c:set var="age" value="${20}" scope="page"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${age >= 20 }">
    <b>성인입니다.</b><br>
</c:if>
<c:if test="${age < 20 }">
    <b>미성년자입니다.</b><br>
</c:if>
</body>
</html>
