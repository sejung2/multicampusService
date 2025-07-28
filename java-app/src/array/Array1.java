package array;

import java.util.Arrays;

public class Array1 {
    public static void main(String[] args) {
        // 배열 기본 문법
        // 1. 배열 선언 - 사용불가
        int[] a;
        int b[];

        // 2. 배열 생성 - 메모리 할당
        a = new int[3]; // int형 배열 3개 생성

        // 값 직접 저장
        a[0] = 10;
        a[1] = 20;
        a[2] = 30;

        // 원소 접근
        System.out.println("a[1] = " + a[1]);

        // 전체 원소 접근
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

        // 배열 변수 a에 저장된 값 출력
        System.out.println(a); // 실제 주소가 아닌 16진수 형태의 가상 주소 출력
        // [ -> 1차원 배열, I -> int , @ -> 참조값, 16진수 주소값
        // 예: [I@1a2b3c4

        // 배열 선언, 할당, 값 저장
        int[] score = new int[]{90, 30, 40};
        for (int i = 0; i < score.length; i++) {
            System.out.println(score[i]);
        }

        // 배열 선언, 할당, 배열 크기 설정과 값저장 -> 배열 값을 초기화{} 하면서 크기 명시하면 오류 발생
        // int[] score2 = new int[3]{90, 30, 40}; // 오류 발생

        // 선언해놓은 b 배열 생성하고 값 저장 : 선언시에만 가능
        // b = {10, 45, 70};
        b = new int[3];
        for (int i = 0; i < b.length; i++) {
            b[i] = i;
        }

        // 참조 타입의 배열
        String[] flowers = { "해바라기", "장미", "튤립" };
        for (int i = 0; i < flowers.length; i++) {
            System.out.println(flowers[i] + " ");
        }
        System.out.println();

        // Arrays 클래스의 toString() 메서드 사용
        System.out.println(Arrays.toString(flowers));

        // 배열 길이가 0인 배열 생성
        int[] score1 = new int[0];
        int score2[] = new int[]{};
        int[] score3 = {}; // 길이가 0인 배열 생성
        System.out.println(score1.length);
        System.out.println(score2.length);
        System.out.println(score3.length);
    }

}
