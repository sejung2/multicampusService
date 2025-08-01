package genericCollection.sec06;

import java.util.ArrayList;
import java.util.List;

public class ArrayListMain {
    public static void main(String[] args) {
        // ArrayList Collection
        List<Integer> list = new ArrayList<>();
        // Adding elements to the ArrayList
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        for (Integer i : list) {
            System.out.println("Element: " + i);
        }
        System.out.println();

        list.add(0, 5); // Adding an element at index 0 // This will shift existing elements to the right
        for (Integer i : list) {
            System.out.println("Element after adding at index 0: " + i);
        }
        System.out.println();

        list.remove(1);
        for (Integer i : list) {
            System.out.println("Element after removing index 1: " + i);
        }

        System.out.println();
        System.out.println(list.contains(90));
    }
}
