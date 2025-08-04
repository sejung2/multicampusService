package genericCollection.sec16;

import java.util.*;

public class HashTableEx {
    public static void main(String[] args) {
        // HashTable은 HashMap과 사용법은 같지만, 멀티스레드 환경에서 안전하게 사용하기 위해 설계된 클래스입니다.
        // 동기화 구현 되어 있으므로 스레드 접근하면 객체 잠금 발생 - 다른 스레드가 HashTable에 접근할 수 없습니다.
        // 멀티 스레드가 아닌경우 비효율적
        Map<String, String> map = new Hashtable<>();

        map.put("spring", "value1");
        map.put("summer", "value1");
        map.put("fall", "value1");
        map.put("winter", "value1");

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("아이디와 비밀번호를 입력하세요: ");
            System.out.print("아이디 : ");
            String id = sc.nextLine().trim();
            System.out.print("비밀번호 : ");
            String password = sc.nextLine().trim();

            // 아이디에 해당하는 키가 존재하는지 확인
            if (map.containsKey(id)) {
                // 비밀번호 일치 확인
                if (map.get(id).equals(password)) {
                    System.out.println("로그인 성공");
                    break; // 로그인 성공 시 루프 종료
                } else {
                    System.out.println("비밀번호가 일치하지 않습니다.");
                }
            } else {
                System.out.println("입력하신 아이디가 존재하지 않습니다.");
            }
        }
    }

}
