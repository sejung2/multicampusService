package genericCollection.sec06;

import java.util.Arrays;
import java.util.List;

public class AsListMain {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("user1", "user2", "user3");
        for (String s : list1) {
            System.out.println(s);
        }

        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5);
        for (Integer s : list2) {
            System.out.println(s);
        }

        list2.set(1, 5);
        for (Integer i : list2) {
            System.out.println(i);
        }

//        list2.add(10); // asList를 사용하여 생성된 리스트는 크기가 고정되어 있어 요소를 추가할 수 없음
//        for (Integer i : list2) {
//            System.out.println(i);
//        }
    }
}
