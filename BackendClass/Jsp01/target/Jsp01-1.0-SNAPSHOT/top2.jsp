<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%
    Date date = new Date();
%>

<font color="blue" size="3pt">
    <h3>top.jsp 입니다</h3>
    <%= date.toLocaleString() %>

</font>