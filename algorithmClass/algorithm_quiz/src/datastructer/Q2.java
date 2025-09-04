package datastructer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Queue;

public class Q2 {
    public static void main(String[] args) {
        // Queue Quiz : 카드 문제
        // 1부터 N까지 번호가 부여된 N장의 카드가
        //1이 위로, N이 마지막에 오도록 번호 순서대로 놓여있다.
        //제일 위에 있는 카드를 바닥에 버리고, 그 다음 제일 위에 있는 카드를 제일 밑으로 옮긴다.
        //이 과정을 반복했을 때 버린 카드들을 순서대로 출력하고 마지막에 남게 되는 카드를 출력하는 프로그램을 작성하시오

        //q2(4);
        answer(3);
    }

    private static void answer(int n) {
        Queue<Integer> cards = new ArrayDeque<>();
        ArrayList<Integer> trashBox = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            cards.offer(i);
        }

        while(cards.size() > 1) {
            trashBox.add(cards.poll());
            cards.offer(cards.poll());
        }

        System.out.println("trashBox = " + trashBox);
        System.out.println("last card = " + cards.poll());
    }

    private static void q2(int number) {
        Deque<Integer> cards = new ArrayDeque<>();
        for (int i = 1; i <= number; i++) {
            cards.offer(i);
        }

        ArrayList<Integer> trash = new ArrayList<>();

        while (cards.size() > 1) {
            trash.add(cards.pollFirst());
            int temp = cards.pollFirst();
            cards.offerLast(temp);
        }

        System.out.println("trash = " + trash);
        System.out.println("last card = " + cards.poll());
    }
}
