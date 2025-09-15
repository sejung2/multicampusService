<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%!
    int x = 10; // 전역 변수
    float f = 3.14f; // 전역 변수

    public int plus(int x){
        return x + 10;
    }
%>

<%= x %>
<br/>
f 변수의 값 : <%= f %>
<br/>
plus 메서드 호출 : <%= plus(10) %>
</body>
</html>
