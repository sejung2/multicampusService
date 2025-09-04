package divideandconquer;

public class Q1 {
    public static void main(String[] args) {
        // 분할정복 문제 : 거듭제곱 최적화
        //매개변수 A, B를 받아 A의 B 제곱 값을 반환하는 함수를 작성하시오.
        //함수의 시간복잡도는 O(logN)입니다.
        //B가 짝수 일 경우
        //A^B =  A ^ (B/2)  * A ^ (B/2)
        //B가 홀수 일 경우
        //A^B = A ^ (B/2)  * A ^ (B/2) * A
        q1(5, 2);
        answer(5, 2);
    }

    private static int answer(int numA, int numB) {
        // 잘 모르겠습니다.
        System.out.println(Math.pow(numA, numB));
        if(numB == 0) return 1;
        if(numB == 1) return numA;

        int half = answer(numA, numB / 2);

        if (numB % 2 == 0) {
            return half * half;
        } else {
            return half * half * numA;
        }
    }

    private static void q1(int numA, int numB) {
        // 잘 모르겠습니다.
        System.out.println(Math.pow(numA, numB));
    }

}
