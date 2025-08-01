package genericCollection.sec06;

import java.util.*;

public class ArrayListExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 4; i++) {
            System.out.print("단어를 입력하세요>>");
            list.add(sc.nextLine());
        }
        sc.close();
        System.out.println("----------------------");
        String longestWord = list.get(0);
        for (String s : list) {
            if (s.length() > longestWord.length()) {
                longestWord = s;
            }
            System.out.print(s + " ");
        }
        System.out.println();
        System.out.println("가장 긴 단어는 : " + longestWord);
        System.out.println("가장 긴 단어의 길이는 : " + longestWord.length());
    }
}
