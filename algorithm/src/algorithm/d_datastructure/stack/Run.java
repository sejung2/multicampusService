package algorithm.d_datastructure.stack;

import algorithm.d_datastructure.map._HashMap;

import java.util.HashMap;
import java.util.Stack;

public class Run {
    public static void main(String[] args) {
        String s = "{}()[]";
        String s1 = "{()[]()}";
        String s2 = "{([}])}";

        System.out.println(isPair(s));
        System.out.println(isPair(s1));
        System.out.println(isPair(s2));
    }

    private static boolean isPair(String text) {
        HashMap<Character, Character> pairMap = new HashMap<>();
        pairMap.put('(', ')');
        pairMap.put('{', '}');
        pairMap.put('[', ']');

        _Stack<Character> stack = new _Stack<>();

        for (char ch : text.toCharArray()) {
            if (pairMap.containsKey(ch)) {
                stack.push(ch);
                continue;
            }
            if((!")}]".contains(String.valueOf(ch)))) continue;
            if (stack.isEmpty()) return false; // 스택이 비어있는데 닫는 괄호가 나왔을 때}

            char open = stack.pop();
            if (ch != pairMap.get(open)) return false;
        }
        return stack.isEmpty();
    }

//    Stack<Character> stack = new _Stack<>();
//
//        for (char ch : text.toCharArray()) {
//        if((!"({[".contains(String.valueOf(ch)))) {
//            stack.push(ch);
//            continue;
//        }
//
//        if((!")}]".contains(String.valueOf(ch)))) continue;
//        if (stack.isEmpty()) return false; // 스택이 비어있는데 닫는 괄호가 나왔을 때}
//        int k = stack.pop();
//        if(ch + k != 81 && ch +k != 184 && ch + k != 248) return false; // 닫는 괄호와 짝이 맞지 않을 때
//    }
//        return stack.isEmpty();

//    private static boolean isPair(String s) {
//        Stack<String> stack = new Stack<>();
//        String[] arr = s.split("");
//        for (String string : arr) {
//            if (string.equals("{") || string.equals("[") || string.equals("(")) {
//                stack.push(string);
//            } else if (stack.isEmpty())  {
//                return false;
//            } else stack.pop();
//        }
//        return stack.isEmpty();
//    }
}
