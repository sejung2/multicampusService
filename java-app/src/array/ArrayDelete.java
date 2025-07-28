package array;

public class ArrayDelete {
    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4, 5};
        // num의 원소값을 유지하고 크기는 10인 배열이 필요해짐
        int[] newNum = new int[10];

        // num의 원소값을 newNum에 복사
        for (int i = 0; i < num.length; i++) {
            newNum[i] = num[i];
        }

        //newNum 출력
        for (int i = 0; i < newNum.length; i++) {
            System.out.print(newNum[i] + " ");
        }
        System.out.println();
        for (int i : newNum) {
            System.out.print(i + " ");
        }

        num = null; // num 배열을 삭제
        num[1] = 10; // 이 줄은 NullPointerException을 발생시킴
        System.out.println(num[1]); // 이 줄은 실행되지 않음
    }
}
