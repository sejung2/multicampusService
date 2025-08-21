package algorithm.d_datastructure.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz { //문자열에서 가장 많이 반복되는 문자 찾기
    public static void main(String[] args) {
        String s = new Scanner(System.in).nextLine();
        List<String> result = new ArrayList<>();
        _HashMap<String, Integer> count = new _HashMap<>();

        String[] arr = s.split(""); //문자열을 문자 단위로 분리
        for (String c : arr) {
            if(count.get(c) == null) {
                count.put(c, 1); //문자가 처음 등장하면 카운트 1로 초기화
            } else {
                count.put(c, count.get(c) + 1); //이미 등장한 문자면 카운트 증가
            }
        }

        int maxCount = 0;



    }
}
