package genericCollection.sec08;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListEx {
    public static void main(String[] args) {
        // 성능비교
        // List = ArrayList
        // List = LinkedList

        List<String> listArrList = new ArrayList<>();
        List<String> listLinkedList = new LinkedList<>();

        ArrayList<String> listArrayList = new ArrayList<>();
        LinkedList<String> listLinked = new LinkedList<>();

        ///  ////////////////////////
        long startTime = System.nanoTime();

        for (int i = 0; i < 10000; i++) {
            listArrList.add(0, String.valueOf(i));
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("listArrList 소요 시간: " + duration + " nanoseconds");

        long startTime1 = System.nanoTime();

        for (int i = 0; i < 10000; i++) {
            listLinkedList.add(0, String.valueOf(i));
        }

        long endTime1 = System.nanoTime();
        long duration1 = endTime1 - startTime1;
        System.out.println("listLinkedList 소요 시간: " + duration1 + " nanoseconds");

        /// ////////////////////////
        // ArrayList와 LinkedList의 성능 비교
        long startTime2 = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            listArrayList.add(0, String.valueOf(i));
        }
        long endTime2 = System.nanoTime();
        long duration2 = endTime2 - startTime2;
        System.out.println("listArrayList 소요 시간: " + duration2 + " nanoseconds");

        long startTime3 = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            listLinked.add(0, String.valueOf(i));
        }
        long endTime3 = System.nanoTime();
        long duration3 = endTime3 - startTime3;
        System.out.println("listLinked 소요 시간: " + duration3 + " nanoseconds");
    }
}
