<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ArrayList 사용</title>
    <%
        request.setCharacterEncoding("UTF-8");
    %>
</head>
<body>
    아이디: ${memberList[0].id} <br>
    비밀번호: ${memberList[0].pwd} <br>
    이름: ${memberList[0].name} <br>
    이메일: ${memberList[0].email} <br>
</body>
</html>
