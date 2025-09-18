<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>숫자 맞히기 게임</title>
    <br>

    <!-- 게임 폼 -->
    <form name="guessForm" method="post" action="guess">
        1 ~ 10 사이의 숫자 하나를 고르세요:
        <input type="text" name="choice">

        <input type="hidden" name="answer" value="${answer}">
        <input type="hidden" name="attempt" value="${attempt}">

        <input type="submit" value="제출">
    </form>

    <p>
        ${error != null ? error : ""}
    </p>

    <!-- 결과 출력 -->
    <h3>게임 결과</h3>
    <p>당신의 선택: ${user}
    </p>
    <p>결과: ${result}
    </p>
    <br>
    <!-- 게임 다시하기 여부 -->
    <a href="guess">다시하기 </a>
        <br>

        <!-- 돌아가기 링크 -->
        <p>
            <a href="main/GameView.jsp">게임 선택 화면으로 돌아가기</a>
        </p>
</head>
<body>

</body>
</html>
