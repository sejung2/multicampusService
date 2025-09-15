<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Member 객체 바인딩</title>
</head>
<body>
아이디: ${mem.id} <br>
비밀번호: ${mem.pwd} <br>
이름: ${mem.name} <br>
이메일: ${mem.email} <br>

<h3>태그의 속성 값으로 표현언어 사용</h3>
<form method="post" action="memberEdit.jsp">
    아이디: <input type="text" name="id" value="${mem.id}" readonly><br>
    비밀번호: <input type="text" name="pwd" value="${mem.pwd}"><br>
    이름: <input type="text" name="name" value="${mem.name}"><br>
    이메일: <input type="text" name="email" value="${mem.email}"><br>
    <input type="submit" value="수정완료">
</form>
</body>
</html>
