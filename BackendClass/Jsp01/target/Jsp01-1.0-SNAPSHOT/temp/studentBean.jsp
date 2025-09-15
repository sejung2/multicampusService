<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="student" class="jsp.jsp01.sec01.StudentBean" scope="page"/>
<html>
<head>
    <title>자바 빈</title>
</head>
<body>
<h3>beans 속성값 설정</h3>
<jsp:setProperty name="student" property="stdNo" value="2025001"/>
<jsp:setProperty name="student" property="stdName" value="홍길동"/>
<jsp:setProperty name="student" property="stdPhone" value="010-1234-5678"/>
<jsp:setProperty name="student" property="stdAddress" value="서울시 강남"/>
<jsp:setProperty name="student" property="stdYear" value="1"/>

<h3>beans 속성값 출력(액션태그 사용)</h3>
학번 :
<jsp:getProperty name="student" property="stdNo"/>
<br/>
이름 :
<jsp:getProperty name="student" property="stdName"/>
<br/>
전화 :
<jsp:getProperty name="student" property="stdPhone"/>
<br/>
주소 :
<jsp:getProperty name="student" property="stdAddress"/>
<br/>
학년 :
<jsp:getProperty name="student" property="stdYear"/>

<h3>beans 속성값 출력(Getter 사용)</h3>
학번 = <%= student.getStdName()%></br>
성명 = <%= student.getStdName()%></br>
전화 = <%= student.getStdPhone()%></br>
주소 = <%= student.getStdAddress()%></br>
학년 = <%= student.getStdYear()%></br>
</body>
</html>
