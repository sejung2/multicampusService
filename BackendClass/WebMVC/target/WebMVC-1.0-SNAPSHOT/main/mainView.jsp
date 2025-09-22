<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>WebMvc</title>
</head>
<body>

<c:choose>
    <c:when test='${msg == "loginSuccess"}'>
        <script>
            window.onload = function () {
                alert(${user} + "님 로그인 성공");
            }
        </script>
    </c:when>
    <c:when test='${msg == "logoutSuccess"}'>
        <script>
            window.onload = function () {
                alert("로그아웃 되었습니다.");
            }
        </script>
    </c:when>
</c:choose>
<h1>${user != null ? user : ""} 환영합니다</h1>

<h2>메뉴</h2>

<c:choose>
    <c:when test="${user != null}">
        <a href="/member/logoutMember.do">로그아웃</a> <br>
        <a href="<c:url value="${pageContext.request.contextPath}/main/GameView.jsp"/>">게임하기</a> <br>
    </c:when>
    <c:otherwise>
        <a href="/member/loginMember.do">로그인</a> <br>
        <a href="/member/memberForm.do">회원가입</a> <br>
        <span style="color: gray; cursor: not-allowed;">게임하기 (로그인 필요)</span> <br>
    </c:otherwise>
</c:choose>
</body>
</html>
