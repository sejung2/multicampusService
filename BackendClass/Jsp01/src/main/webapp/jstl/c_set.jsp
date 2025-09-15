<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<c:set var="id" value="hong" scope="page"/>
<c:set var="pwd" value="1234" scope="page"/>
<c:set var="name" value="${'홍길동'}" scope="page"/>
<c:set var="age" value="${20}" scope="page"/>
<html>
<head>
    <title>c:set 사용예제</title>
</head>
<body>
${id} <br>
${pwd} <br>
${name} <br>
${age} <br>
</body>
</html>
