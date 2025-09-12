<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>forward 액션 태그</title>
</head>
<body>
<%-- user_id parameter값을 전달 받으면 login, 아니면 로그인 페이지로 전환 --%>
<%
    request.setCharacterEncoding("UTF-8");
    String user_id = request.getParameter("user_id");

    if (user_id == null || user_id.equals("")) {
        // 로그인 페이지로 전환 - jsp 액션 태그 forward
        // 서블릿의 dispatch와 같은 포워딩 - 클라이언트 입장에서는 loginForwardResult.jsp 요청되어있고 포워딩되어도 클라이언트에서 표시되지 않음
%>
<jsp:forward page="login_forward.jsp"/>
<%
    }
%>

<h3>환영합니다 <%=user_id%> 님</h3>
</body>
</html>