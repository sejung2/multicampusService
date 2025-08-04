package genericCollection.sec13;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapEx {
    public static void main(String[] args) {
        // key 를 통해서 data를 구분 함
        Map<String, Integer> map = new HashMap<>();

        map.put("홍길동", 90);
        map.put("이순신", 95);
        map.put("강감찬", 85);
        map.put("홍길동", 100); // 중복된 key는 덮어쓰기

        System.out.println("총 객체 수 = " + map.size());

        System.out.println(map.get("홍길동")); // key로 value를 가져옴
        // 전체 객체 순회
        // map은 순서가 보장되지 않음
        System.out.println("----------------------");
        for (String s : map.keySet()) {
            System.out.println(s + " : " + map.get(s));
        }

        //keySet 변수 저장
        Set<String> keySet = map.keySet(); // keySet() 메서드는 Map의 모든 키를 Set으로 반환

        System.out.println("----------------------");
        map.forEach((key, value) -> {
            ;
            System.out.println(key + " : " + value);
        });

        System.out.println("----------------------");
        // entrSet을 이용
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " : " + value);
        }
    }
}
