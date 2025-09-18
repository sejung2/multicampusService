package com.seing.practice.webmvc.service;

import java.util.HashMap;
import java.util.Map;

public class GaBaBo {
    private String[] choices = {"가위", "바위", "보"};

    public Map<String, String> startGame(int playerChoice) {
        int computerChoice = (int) (Math.random() * 3) + 1; // 1: 가위, 2: 바위, 3: 보
        String resultMsg = result(playerChoice, computerChoice);

        Map<String, String> gameResult = new HashMap<>();
        gameResult.put("user", choices[playerChoice - 1]);
        gameResult.put("computer", choices[computerChoice - 1]);
        gameResult.put("result", resultMsg);

        return gameResult;
    }

    private String result(int userChoice, int computerChoice) {
        if (userChoice == computerChoice) {
            // 사용자와 선택이 같을 때
            return "결과: 비겼습니다!";
        } else if ((userChoice == 1 && computerChoice == 3) ||
                (userChoice == 2 && computerChoice == 1) ||
                (userChoice == 3 && computerChoice == 2)) {
            // 사용자 승리 조건
            return "결과: 당신이 이겼습니다!";
        } else {
            // 컴퓨터 승리 조건
            return "결과: 컴퓨터가 이겼습니다!";
        }
    }
}
