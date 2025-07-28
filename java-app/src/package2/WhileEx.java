package package2;

import java.util.Scanner;

public class WhileEx {
    public static void main(String[] args) {
        // 사용자가 7을 입력할 때 까지 반복
        Scanner scanner = new Scanner(System.in);
        int inputNum = 0;
        while(inputNum != 7) {
            System.out.print("숫자를 입력하세요 (7을 입력하면 종료): ");
            inputNum = scanner.nextInt();
        }
        System.out.println("프로그램을 종료합니다.");
        scanner.close();
    }
}
