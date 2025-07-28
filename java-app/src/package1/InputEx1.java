package package1;

import java.util.Scanner;

//Scanner 클래스를 활용하여 입력을 사용할 수 있음
public class InputEx1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1, num2;
        System.out.print("숫자 1을 입력하세요: ");
        num1 = sc.nextInt();
        System.out.print("숫자 2를 입력하세요: ");
        num2 = sc.nextInt();

        System.out.println("두 수의 합 = " + (num1 + num2));

        // 실수 입력
        sc.nextFloat();

        // 문자열 입력 - 기본 입력
        sc.next();

        sc.close(); //할당 받은 메모리 해제
    }

}
