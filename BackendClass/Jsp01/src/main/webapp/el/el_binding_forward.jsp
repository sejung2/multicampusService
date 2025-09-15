<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        let name = "${name}"; // 표현언어를 script 태그내에 사용 "홍길동"
    </script>
</head>
<body>
request 객체에 attribute로 바인딩된 data el로 출력<br>
아이디: ${id}<br>
비밀번호: ${pwd}<br>
이름: ${name}<br>
이메일: ${email}<br>
</body>
</html>