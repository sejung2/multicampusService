package datastructer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Q3 {
    public static void main(String[] args) {
        // Queue Quiz : 요세푸스 순열 문제
        // 1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다.
        //1번부터 N번 사람이 있는 방향으로 K번째 사람을 순차적으로 제거한다.
        //모든 사람이 제거되었을 때 제거되는 사람의 순서를 담은 배열을 반환 하시오

       // q3(7, 3);

        answer(10, 3);
    }

    private static void answer(int n, int k) {
        Queue<Integer> person = new ArrayDeque<>();
        ArrayList<Integer> removed = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            person.offer(i);
        }

        while (person.size() > 1) {
            for (int i = 0; i < k - 1; i++) {
                person.offer(person.poll());
            }

            removed.add(person.poll());
        }

        System.out.println("removed = " + removed);
        System.out.println("person = " + person);
    }

    private static void q3(int i, int i1) {
        Queue<Integer> queue = new ArrayDeque<>();
        StringBuilder result = new StringBuilder();

        for (int j = 1; j <= i; j++) {
            queue.offer(j);
        }

        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            int temp = queue.poll();
            if (count % i1 == 0) {
                result.append(temp).append(", ");
            } else {
                queue.offer(temp);
            }
        }

        result.setLength(result.length() - 2); //마지막 ", " 제거
        System.out.println(result);
    }

}

