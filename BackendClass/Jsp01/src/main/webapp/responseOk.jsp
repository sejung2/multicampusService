<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!-- request 객체에 저장되어서 전달되는 answer 값에 따라
두 페이지 중 하나로 포워딩(redirect)
응답에 대한 표현은 없어 처리만하는 페이지들에서 html 코드 필요 없음-->
<%!String answer; %>
<%
    request.setCharacterEncoding("UTF-8");
    answer = request.getParameter("answer");
    if ("서울".equals(answer)) {
        response.sendRedirect("pass.jsp");
    } else {
        response.sendRedirect("fail.jsp");
    }
%>
