package algorithm.b_star;

import java.util.Scanner;

public class Diamond {
    public static void main(String[] args) {
        // 내 사고 : 너무 어렵게 생각함 : 공백이 별 양 옆에 존재한다고 판단
        int input = new Scanner(System.in).nextInt();
        // i : 1,,,2 ... input
        // 1. 공백의 개수 : input - i
        // 2. 별의 개수 : 2 * i - 1
        // 3. 아랫 부분
        // i : 1,,,, ... input - 1
        // 공백의 개수 : i
        // 별의 개수 : 2 * input - 1 - 2 * i => 2(input - 1) - 1

        for (int i = 1; i < input + 1; i++) {
            for (int j = 0; j < input - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2*i-1; j++) {
                System.out.print("*");
            }
            System.out.println();

        }

        for (int i = 0; i < input; i++){
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * (input - i) - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
