<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
plain text로 출력: 100<br>
표현식으로 출력: <%= 100 %><br>
표현언어(EL)로 출력: ${100}<br>
표현언어(EL)로 출력: ${"문자열"}<br>
표현언어(EL)로 출력: ${true}<br>
표현언어(EL)로 출력: ${true && true}<br>
표현언어(EL)로 출력: ${100 - 90}<br>
표현언어(EL)로 출력: ${100 % 90}<br>
표현언어(EL)로 출력: ${100 mod 90}<br>
<%--표현언어(EL)로 출력: ${"hello" + "world"}<br>--%>
<%--jsp 주석으로 처리 안하면 그대로 해석됨
<%-- 문자열 연산의 결과 --%>
</body>
</html>
