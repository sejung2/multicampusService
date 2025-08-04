package genericCollection.sec11;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetStringEx {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();

        //
        set.add("Java");
        set.add("JDBC");
        set.add("Servlet/JSP");
        set.add("Java"); // 중복된 값은 추가되지 않음
        set.add("iBATIS");

        int size = set.size();
        System.out.println("총 객체 수: " + size);

        // set은 idx가 없으므로 iterator를 사용하여 출력
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println("\t" + element);
        }

        set.remove("JDBC");
        set.remove("iBATIS");
        System.out.println("총 객체 수: " + set.size());

        set.clear();
        if (set.isEmpty()) {
            System.out.println("비어있음");
        }

    }
}
