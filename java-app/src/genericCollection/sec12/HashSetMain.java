package genericCollection.sec12;

import java.util.HashSet;
import java.util.Set;

public class HashSetMain {
    public static void main(String[] args) {
        Set<Member> set = new HashSet<>();

        // 동일값이 필드에 저장되지만 객체의 참조 주소가 다르기 때문에 두 개의 객체로 보고 두 객체 모두 추가됨
        set.add(new Member("홍길동", 25));
        set.add(new Member("홍길동", 25));

        System.out.println("총 객체 수: " + set.size());
        // Member2 객체는 필드값이 완전히 동일하면 동일 객체로 보고 중복 저장되지 않도록 구현
        Set<Member2> set1 = new HashSet<>();

        set1.add(new Member2("홍길동", 25));
        set1.add(new Member2("홍길동", 25));

        System.out.println("총 객체 수: " + set1.size());
    }
}
