package algorithm.b_star;

import java.util.Scanner;

public class ButterFly {
    public static void main(String[] args) {

        int input = new Scanner(System.in).nextInt();

        // 공백의 갯수 : 2(input - i)
        // 별의 개수 : 2 * i
        // 아랫부분
        // 공백의 개수 : 2 * i
        // 별의 개수 : 2(input - i)

        for(int i = 1; i <= input; i++){
            for(int j = 0; j < i; j++){
                System.out.print("*");
            }

            for(int j = 0; j < 2 * (input - i); j++){
                System.out.print(" ");
            }
            for(int j = 0; j < i; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i = 1; i < input; i++){
            for(int j = 0; j < input - i; j++){
                System.out.print("*");
            }
            for(int j = 0; j < 2 * i; j++){
                System.out.print(" ");
            }
            for(int j = 0; j < input - i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
