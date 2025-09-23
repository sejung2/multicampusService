<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>getParameter 사용</title>
</head>
<body>
command 객체 활용해서 view에 전달된 경우 : 자동으로 model에 객체(obj)로 저장해서 view 전달 됨 <br>
표현어에 사용할 때는 객체명.필드명 형태로 사용, 단 @ModelAttribute("변경객체명") 객체명 변경 후 view 전달 가능<br>
학번: ${studentInfo.no} <br>
성명: ${studentInfo.name} <br>
학년: ${studentInfo.year} <br>
</body>
</html>
