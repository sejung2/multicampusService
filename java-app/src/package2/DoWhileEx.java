package package2;

import java.util.Scanner;

public class DoWhileEx {
    public static void main(String[] args) {
        // 입력되는 번호에 따라 해당 과목을 출력
        Scanner scanner = new Scanner(System.in);
        int input;
        String answer;

        System.out.println("과정 안내프로그램");
        do {
            System.out.println("/n 1~4 번호 입력");
            input = scanner.nextInt();
            switch (input) {
                case 1:
                    answer = "자바";
                    break;
                case 2:
                    answer = "파이썬";
                    break;
                case 3:
                    answer = "C++";
                    break;
                case 4:
                    answer = "자바스크립트";
                    break;
                default:
                    answer = "잘못된 번호입니다.";
            }
            System.out.println("/n계속 입력하시겠습니가?(y/n)");
            answer = scanner.next();
        } while(answer.contentEquals("y"));
        System.out.println("종료 합니다");
        scanner.close();

    }
}
