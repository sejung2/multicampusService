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
<%! String msg = "아이디를 입력하세요"; %>
<%
    request.setCharacterEncoding("UTF-8");
    String user_id = request.getParameter("user_id");

    if (user_id == null || user_id.equals("")) {
        // jsp 액션태그 param 사용해서 포워딩되는 페이지로 msg 전달 - param 태그는 parameter를 어느 페이지로 전달할 것인지 설정되어있어야 함
        // forward/include 액션 태그를 이용해서 parameter를 전달
%>
<jsp:forward page="login_param.jsp">
    <jsp:param value="<%=msg%>" name="msg"/>
</jsp:forward>

<%
    }
%>

<h3>환영합니다 님</h3>
</body>
</html>