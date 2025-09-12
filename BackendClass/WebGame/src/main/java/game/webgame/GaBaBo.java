package game.webgame;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GaBaBo {
    Scanner userInput = new Scanner(System.in);
    // 가위 바위 보 게임 클래스
    private int userChoice; // 사용자로부터 입력받을 값
    private int computerChoice; // 컴퓨터가 랜덤으로 선택한 값

    private final String[] choices = {"가위", "바위", "보"}; // 선택지
    public boolean isGameOver; // 게임 종료 여부

    public GaBaBo() {
        this.userChoice = 0; // 초기값 설정
        this.computerChoice = 0; // 초기값 설정
        this.isGameOver = false; // 게임이 종료되지 않았음을 나타냄
    }

    public void startGame() {
        printMenu();
        while (!isGameOver) {
            System.out.println("================================");
            System.out.print("번호 입력: ");
            try {
                // 사용자로부터 값을 입력받음
                this.userChoice = userInput.nextInt();
                // 컴퓨터가 랜덤으로 선택한 값을 생성
                this.computerChoice = (int) (Math.random() * 3) + 1; // 1부터 3까지의 랜덤 값 생성
                result(userChoice); // 입력된 값과 컴퓨터의 선택을 비교
                // 컴퓨터의 선택을 출력
                System.out.println("컴퓨터는 " + choices[this.computerChoice - 1] + "입니다.");
                System.out.print("계속하시겠습니까? (y/n): ");
                // 게임 종료 여부를 결정
                String continueGame = userInput.next().toLowerCase(); // 항상 일관된 값을 받도록 소문자로 변환
                askEnd(continueGame);
            } catch (IllegalArgumentException | InputMismatchException e) {
                // 잘못된 입력 처리 - 다시 입력 받을 수 있게 진행
                System.out.println("잘못된 입력입니다. 1, 2, 3 중 하나를 입력해주세요.");
                this.isGameOver = false; // 게임이 종료되지 않도록 설정
                userInput.next(); // 잘못된 입력을 제거
            } catch (Exception e) {
                // 예상치 못한 오류 처리
                System.out.println("예상치 못한 오류가 발생했습니다: " + e.getMessage());
                endGame();
            }
        }
        resetGame(); // 게임이 종료되면 초기화
    }

    private void resetGame() {
        isGameOver = false; // 게임 종료 상태 초기화
        userChoice = 0; // 사용자 선택 초기화
        computerChoice = 0; // 컴퓨터 선택 초기화
    }

    private void askEnd(String continueGame) {
        if (continueGame.equals("y")) {
            // 'y' 입력 시 게임을 계속 진행
            this.isGameOver = false;
        } else if (continueGame.equals("n")) {
            // 'n' 입력 시 게임 종료
            endGame();
        } else {
            // 잘못된 입력 처리 - 다시 입력 받을 수 있게 진행
            System.out.println("잘못된 입력입니다. 'y' 또는 'n'을 입력해주세요.");
            this.isGameOver = false; // 게임이 종료되지 않도록 설정
            System.out.print("다시 입력: ");
            String newContinueGame = userInput.next().toLowerCase(); // 다시 입력 받기
            askEnd(newContinueGame); // 재귀적으로 다시 입력 받기
        }
    }

    private void endGame() {
        System.out.println("게임을 종료합니다.");
        this.isGameOver = true;
    }

    private void printMenu() {
        System.out.println("    가위바위보게임");
        System.out.println("가위 바위 보 게임: 1. 가위, 2. 바위, 3. 보");
    }

    private void result(int userChoice) {
        if (userChoice == this.computerChoice) {
            // 사용자와 컴퓨터의 선택이 같을 때
            System.out.println("결과: 비겼습니다!");
        } else if ((userChoice == 1 && this.computerChoice == 3) ||
                (userChoice == 2 && this.computerChoice == 1) ||
                (userChoice == 3 && this.computerChoice == 2)) {
            // 사용자 승리 조건
            System.out.println("결과: 당신이 이겼습니다!");
        } else {
            // 컴퓨터 승리 조건
            System.out.println("결과: 컴퓨터가 이겼습니다!");
        }
    }
}
