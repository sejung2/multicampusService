<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>request 객체</title>
</head>
<body>
    <%
        out.println("서버 : " + request.getServerName() + "<br/>");
        out.println("포트 : " + request.getServerPort() + "<br/>");
        out.println("요청 방식 : " + request.getMethod() + "<br>");
        out.println("프로토콜 : " + request.getProtocol() + "<br>");
        out.println("URL : " + request.getRequestURL() + "<br>");
        out.println("URI : " + request.getRequestURI() + "<br>");
        out.println("ContextPath : " + request.getContextPath() + "<br>");
        out.println("ServletPath : " + request.getServletPath() + "<br>");
    %>
</body>
</html>
