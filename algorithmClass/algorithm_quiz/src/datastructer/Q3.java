package datastructer;

import java.util.ArrayDeque;
import java.util.Queue;

public class Q3 {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        int n = 7; // 사람의 수
        int k = 3; // k번째 사람을 제거

        int pointer = 0; // 제거할 사람을 가리키는 포인터

        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        for (int i = 0; i < queue.size(); i++) {
            kill();
        }
    }

    private static void kill() {

    }
}

