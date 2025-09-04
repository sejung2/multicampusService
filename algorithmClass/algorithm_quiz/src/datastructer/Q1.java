package datastructer;

import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        // 문자열에서 가장 많이 반복되는 문자 찾기
        // 주어진 문자열에서 가장 많이 반복되는 문자를 찾아 배열에 담아 반환하는 함수를 작성하시오.
        System.out.print("문자를 입력하세요: ");
        String s = new Scanner(System.in).nextLine();
        System.out.println("가장 많이 반복되는 글자는: " + q1(s));
        System.out.println(Arrays.toString(answer("multicampus")));
    }

    private static Character[] answer(String text) {
        List<Character> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();

        for (Character c : text.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        int max = 1;
        for (Integer i : map.values()) {
            if(i > max){
                max = i;
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue() == max) {
                list.add(entry.getKey());
            }
        }
        return list.toArray(new Character[list.size()]);
    }

    private static List<String> q1(String s) {
        List<String> result = new ArrayList<>();
        HashMap<String, Integer> count = new HashMap<>();

        String[] arr = s.split(""); //문자열을 문자 단위로 분리
        for (String c : arr) {
            if(count.get(c) == null) {
                count.put(c, 1); //문자가 처음 등장하면 카운트 1로 초기화
            } else {
                count.put(c, count.get(c) + 1); //이미 등장한 문자면 카운트 증가
            }
        }

        int max = 0;
        for (String key : count.keySet()) {
            if(count.get(key) > max) {
                max = count.get(key);
            }
        }

        for (String key : count.keySet()) {
            if(count.get(key) == max) {
                result.add(key);
            }
        }
        return result;
    }
}
