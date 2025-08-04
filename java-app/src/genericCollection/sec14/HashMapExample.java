package genericCollection.sec14;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashMapExample {
    public static void main(String[] args) {
        // 1. 사용자로부터 영문단어=한글단어 형태의 entry를 입력받아 HashMap에 저장하는 로직을 구현
        Map<String, String> dictionary = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("영단어=한글단어 형태로 입력하세요 (종료하려면 exit 입력): ");
            String entry = sc.nextLine();
            if (entry.equals("exit")) {
                System.out.println("종료합니다...");
                break;
            }
            String[] parts = entry.split("=");
            dictionary.put(parts[0], parts[1]); // 영단어를 key로, 한글단어를 value로 저장
        }

        // 2. HashMap에 입력된 영단어를 검색할 수 있는 로직을 구현
        // exit 입력되면 종료
        // 없는 단어 검색 시 "사전에 없는 단어입니다" 출력
        while (true) {
            System.out.print("찾고 싶은 단어는? ");
            String input = sc.nextLine();
            if (input.equals("exit")) {
                System.out.println("종료합니다...");
                break;
            }
            if (dictionary.containsKey(input)) {
                System.out.println(dictionary.get(input));
            } else {
                System.out.println(input + "는 없는 단어 입니다.");
            }
        }
        sc.close();
    }
}
