<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>폼에 입력된 값으로 빈 속성값 설정</title>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
%>

<!-- MemberBean 클래스의 속성값을 한번에 저장: 값은 request 객체 파리미터로 전달-->
<jsp:useBean id="member" class="jsp.jsp01.sec01.MemberBean" scope="page">
    <jsp:setProperty name="member" property="*"/>
</jsp:useBean>

<h3>beans 속성값 출력(Getter 사용)</h3>
아이디 = <%= member.getMemId()%></br>
비밀번호 = <%= member.getMemPwd()%></br>
이름 = <%= member.getMemName()%></br>
이메일 = <%= member.getMemEmail()%></br>
</body>
</html>
