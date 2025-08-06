package game_project.game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Guess {
    Scanner userInput = new Scanner(System.in);
    // 숫자 맞추기 게임 클래스
    private int userChoice; // 사용자로부터 입력받을 값
    private int computerChoice; // 컴퓨터가 랜덤으로 선택한 값
    private boolean bullsEye = true; // 한번에 맞추는 경우를 위한 변수

    public boolean isGameOver; // 게임 종료 여부

    public Guess() {
        this.userChoice = 0; // 초기값 설정
        this.computerChoice = 0; // 초기값 설정
        this.isGameOver = false; // 게임이 종료되지 않았음을 나타냄
    }

    public void startGame() {
        printMenu();
        System.out.println("---------------------------------");
        this.computerChoice = (int) (Math.random() * 10) + 1; // 1부터 10까지의 랜덤 값 생성
        System.out.print("번호 입력: ");
        while (!isGameOver) {
            try {
                // 사용자로부터 값을 입력받음
                this.userChoice = userInput.nextInt();
                inputValidation(userChoice); // 입력값 검증 메소드 호출

                // 입력된 값과 컴퓨터의 선택을 비교
                if (userChoice == computerChoice && bullsEye) {
                    System.out.println("축하합니다 한번에 맞추셨습니다!");
                } else if (userChoice == computerChoice) {
                    System.out.println("드디어 맞추셨습니다! 정답은 " + computerChoice + "입니다.");
                } else {
                    System.out.print("아닙니다. 다시 시도해보세요. 다시 입력: ");
                    bullsEye = false; // 한번에 맞추지 못했음을 나타냄
                    continue; // 잘못된 입력 시 다시 입력 받도록 루프를 계속 진행
                }

                System.out.print("계속하시겠습니까? (y/n): ");
                // 게임 종료 여부를 결정
                String continueGame = userInput.next().toLowerCase(); // 항상 일관된 값을 받도록 소문자로 변환
                isFinish(continueGame);
            } catch (IllegalArgumentException e) {
                System.out.println("입력 오류: " + e.getMessage());
                // 잘못된 입력에 대한 예외 처리
                isGameOver = false; // 게임이 종료되지 않도록 설정
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
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
        userChoice = 0; // 사용자 입력 초기화
        bullsEye = true; // 한번에 맞추는 경우를 위한 변수 초기화
    }

    private void isFinish(String continueGame) {
        while (true) {
            if (continueGame.equals("y")) {
                // 게임을 계속 진행
                System.out.println("게임을 계속합니다.");
                this.bullsEye = true; // 한번에 맞추는 경우를 위한 변수 초기화
                this.computerChoice = (int) (Math.random() * 10) + 1; // 새로운 랜덤 값 생성
                break; // 루프 종료
            } else if (continueGame.equals("n")) {
                // 게임 종료
                endGame();
                break; // 루프 종료
            } else {
                // 잘못된 입력 처리
                System.out.print("잘못된 입력입니다. 다시 입력해주세요 (y/n): ");
                continueGame = userInput.next().toLowerCase(); // 소문자로 변환하여 일관성 유지
            }
        }
    }

    private void inputValidation(int userChoice) {
        if (userChoice < 1 || userChoice > 10) {
            // 입력값이 1~10 범위를 벗어날 경우 예외 처리
            throw new IllegalArgumentException("잘못된 입력입니다. 1부터 10 사이의 숫자를 입력해주세요.");
        }
    }

    private void endGame() {
        // 게임 종료 메시지 출력
        System.out.println("게임을 종료합니다.");
        this.isGameOver = true;
    }

    private void printMenu() {
        System.out.println("     숫자 맞추기 게임    ");
        System.out.println("---------------------------------");
        System.out.println("어떤 숫자일까요? 알아 맞혀보세요! (1~10)");
    }
}
