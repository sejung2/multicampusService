<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>getParameter 사용</title>
</head>
<body>
학번: ${no} <br>
성명: ${name} <br>
학년: ${year} <br>

<br>
url을 통한 데이터 전달 <br>
학번을 서버로 전달해서 해당 학번 학생의 정보를 확인 <br>
https://localhost:8080/students/studentDetailView/001 <br>
학번: <a href="${pageContext.request.contextPath}/student/studentDetailView/${no}">${no}</a> <br>
url 통한 데이터 여러개 전달 <br>
학번: <a href="${pageContext.request.contextPath}/student/studentDetailView/${no}/${name}/${year}">${no}</a> <br>
url 통한 정적 데이터 여러개 전달 <br>
학번: <a href="${pageContext.request.contextPath}/student/studentDetailView/${no}/${name}/${year}">${no}</a> <br>
</body>
</html>
