package genericCollection.sec15;

import java.util.HashMap;
import java.util.Map;

public class HashMapStudent {
    public static void main(String[] args) {
        // put 3 Students score in HashMap
        // Student Class를 key로 점수를 value로 저장

        Map<Student, Integer> map = new HashMap<>(); // 입력 순서는 보장되지 않음
        // Map<Student, Integer> map = new LinkedHashMap<>(); // 입력 순서를 보장하려면 LinkedHashMap 사용

        map.put(new Student(1, "홍길동"), 90);
        map.put(new Student(2, "이몽룡"), 82);
        map.put(new Student(3, "성춘향"), 92);
        map.put(new Student(3, "성춘향"), 100); // 중복된 key는 덮어쓰기
        // hashCode(), equals() 재정의해서 객체 필드 값이 동일하면

        for (Student student : map.keySet()) {
            System.out.println(student.getStdNo() + " : " + student.getStdName() + " - " + map.get(student));
        }
    }
}
