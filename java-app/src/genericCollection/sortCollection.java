package genericCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class sortCollection {

    static void printList(ArrayList<String> list) {
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            String str = iter.next();
            String sep;
            if (iter.hasNext()) {
                sep = "->";
            } else {
                sep = "\n";
            }
            System.out.print(str + sep);
        }
    }

    public static void main(String[] args) {
        // sort & reverse
        ArrayList<String> myList = new ArrayList<>();
        myList.add("트랜스포머");
        myList.add("스파이더맨");
        myList.add("아이언맨");
        myList.add("배트맨");

        printList(myList);
        Collections.sort(myList);
        System.out.println("오름차순 정렬:");
        printList(myList);

        Collections.reverse(myList); // 실제 리스트를 뒤집습니다.
        System.out.println("내림차순 정렬:");
        printList(myList);
    }
}
