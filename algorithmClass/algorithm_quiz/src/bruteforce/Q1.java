package bruteforce;

import java.util.ArrayList;
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        // brute_force 문제 : 종말의 수
        // 종말의 수란 어떤 수에 6이 적어도 3개 이상 연속으로 들어가는 수를 말한다.
        //제일 작은 종말의 수는 666이고, 그 다음으로 큰 수는 1666, 2666, 3666, 4666 .... 6660, 6661 … 6666 이다.
        //사용자로부터 전달받은 N번째 종말의 수를 구하는 함수를 구현 하시오.
        Scanner sc = new Scanner(System.in);
        System.out.print("N번째 종말의 수를 입력하세요: ");
        int n = sc.nextInt();
        //q1(n);

        answer(5);
    }

    private static void answer(int n) {
        ArrayList<Integer> doomNumbers = new ArrayList<>();

        for (int doom = 666, cnt = 0; cnt < n; doom++) {
            if (String.valueOf(doom).contains("666")) {
                cnt++;
                doomNumbers.add(doom);
            }
        }
        System.out.println(doomNumbers);
        System.out.println("n : " + doomNumbers.getLast());
    }

    private static void q1(int n) {
        int end = n;
        int doom = 666;
        int count = 0;

        while (true) {
            if (String.valueOf(doom).contains("666")) {
                count++;
            }

            if (count == end) {
                System.out.println(end + "번째 종말의 수는 " + doom + "입니다.");
                break;
            }
            doom++;
        }
    }
}
