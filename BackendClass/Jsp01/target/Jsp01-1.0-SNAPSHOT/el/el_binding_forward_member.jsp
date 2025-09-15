<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="jsp.jsp01.sec01.MemberVO" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    MemberVO mem = new MemberVO("lee", "1234", "이순신", "lee@test.com");
    request.setAttribute("mem", mem);
%>
<jsp:forward page="el_binding_forward_member_result.jsp"/>

</body>
</html>
