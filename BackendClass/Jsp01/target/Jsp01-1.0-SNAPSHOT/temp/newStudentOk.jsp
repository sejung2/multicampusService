<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>폼에 입력된 값으로 빈 속성값 설정</title>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
%>

<!-- StudentBean 클래스의 속성값을 한번에 저장: 값은 request 객체 파리미터로 전달-->
<jsp:useBean id="student" class="jsp.jsp01.sec01.StudentBean" scope="page">
    <jsp:setProperty name="student" property="*"/>
</jsp:useBean>

<h3>beans 속성값 출력(Getter 사용)</h3>
학번 = <%= student.getStdNo()%></br>
성명 = <%= student.getStdName()%></br>
전화 = <%= student.getStdPhone()%></br>
주소 = <%= student.getStdAddress()%></br>
학년 = <%= student.getStdYear()%></br>
취미 =
<%
    String[] stdInterests = student.getStdInterest();
    for (int i = 0; i < stdInterests.length; i++) {
%>
<%= stdInterests[i] + "" %>
<% } %>
</body>
</html>
