package genericCollection.sec06;

import java.util.ArrayList;
import java.util.List;

public class ListGenMain {
    public static void main(String[] args) {
        // use ArrayList with generic type
        List<String> list = new ArrayList<String>();

        list.add("Java");
        list.add("DataBase");
        list.add("Spring");
        list.add("Java"); // can add duplicate elements
        // list.add(100); // compile error, cannot add Integer to List<String>

        System.out.println("총 요소 수: " + list.size());
        for (String s : list) {
            System.out.println("요소: " + s);
        }
        System.out.println();
        list.remove(1);

        for (String s : list) {
            System.out.println("요소: " + s);
        }

        list.add("MultiMedia");
        for (String s : list) {
            System.out.println("요소: " + s);
        }
    }
}
