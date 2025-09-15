<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.* , jsp.jsp01.sec01.MemberVO"
         isELIgnored="false" %>
<%-- import 구문으로 자바 클래스 사용, isIgnored="false"는 true 일 때 el 표현어는 text로 인식됨--%>
<html>
<head>
    <title>ArrayList 사용</title>
    <%
        request.setCharacterEncoding("UTF-8");
    %>
</head>
<body>
<jsp:useBean id="mB" class="jsp.jsp01.sec01.MemberVO"/>
<jsp:useBean id="memberList" class="java.util.ArrayList"/>

<%

%>
</body>
</html>
