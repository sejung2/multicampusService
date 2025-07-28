package array;

import java.util.Scanner;

public class ArrayInputEx1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] num = new int[5]; // 크기가 5인 배열 생성
        System.out.println(num[0]);

        System.out.println("숫자 입력");
        for (int i = 0; i < num.length; i++) {
            System.out.print("num[" + i + "] : ");
            num[i] = sc.nextInt(); // 배열에 숫자 입력
        }

        int max = num[0]; // 최대값을 저장할 변수 초기화

        System.out.print("입력된 값 : ");
        for (int j : num) {
            System.out.print(j + " "); // 입력된 숫자 출력
            if(j > max) {
                max = j; // 최대값 갱신
            }
        }
        System.out.println();
        System.out.println("최대값 : " + max);
        sc.close();
    }
}
