<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>가위바위보 게임</title>
    <br>

    <!-- 게임 폼 -->
    <form name="gababoForm" method="post" action="gababo">
        어떤 걸 내시겠습니까?
        <input type="radio" name="choice" value="1">가위
        <input type="radio" name="choice" value="2">바위
        <input type="radio" name="choice" value="3">보
        <input type="submit" value="제출">
    </form>

    <!-- 결과 출력 -->
    <h3>게임 결과</h3>
    <p>당신이 낸 것: <%= request.getAttribute("choice") == null ? "아직 선택하지 않음" : request.getAttribute("choice") %>
    </p>
    <p>컴퓨터가 낸 것: <%= request.getAttribute("computer") == null ? "아직 선택하지 않음" : request.getAttribute("computer") %>
    </p>
    <p>결과: <%= request.getAttribute("result") != null ? request.getAttribute("result") : "아직 결과 없음" %>
    </p>
    <br>
    <!-- 게임 다시하기 여부 -->
    <form name="retryForm" method="get" action="Gababo.jsp">
        <input type="submit" value="retry">
    </form>
    <br>

    <!-- 돌아가기 링크 -->
    <p>
        <a href="GameView.jsp">게임 선택 화면으로 돌아가기</a>
    </p>
</head>
<body>

</body>
</html>
