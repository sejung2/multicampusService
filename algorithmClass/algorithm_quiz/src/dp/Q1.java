package dp;

import java.util.ArrayList;

public class Q1 {
    public static void main(String[] args) {
        // 동적프로그래밍(Dynamic Programing)
        //n개의 정수로 이루어진 임의의 수열이 주어진다.
        //우리는 이 중 연속된 몇 개의 수를 선택해 구할 수 있는 합 중 가장 큰 합을 구하려 한다.
        //단, 수는 한 개 이상 선택해야 한다.
        //입력 : [10, -4, 3, 1, 5, 6, -35, 12, 21, -1]
        //출력 : 33
        int[] arr = {10, -4, 3, 1, 5, 6, -35, 12, 21, -1};
        //System.out.println(q1(arr));
        answer(arr);
    }

    private static void answer(int[] arr) {
        int currentSum = 0;
        int maxSum = 0;

        for (int i : arr) {
            currentSum = Math.max(currentSum + i, i);
            maxSum = Math.max(maxSum, currentSum);
        }

        System.out.println(maxSum);
    }

    private static int q1(int[] arr) {
        ArrayList<Integer> scores = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < 0) {
                sum = 0;
                continue;
            } else if (arr[i] >= 0 && arr[i + 1] < 0) {
                sum += arr[i];
                scores.add(sum);
                continue;
            } else if (arr[i] >= 0 && arr[i + 1] >= 0) {
                if (i == arr.length - 2) {
                    sum += arr[i] + arr[i + 1];
                } else {
                    sum += arr[i];
                }
            }
            scores.add(sum);
        }
        System.out.println(scores);
        int max = scores.getFirst();
        for (Integer score : scores) {
            if (score > max) {
                max = score;
            }
        }
        return max;
    }
}
