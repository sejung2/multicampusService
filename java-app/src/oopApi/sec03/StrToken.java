package oopApi.sec03;

import java.util.StringTokenizer;

public class StrToken {
    public static void main(String[] args) {
        // StringTokenizer를 사용하여 문자열을 토큰으로 분리
        // 메소드 : countTokens() - 토큰의 개수를 반환
        //         hasMoreTokens() - 다음 토큰이 있는지 확인
        //         nextToken() - 다음 토큰을 반환
        String text = "홍길동/이순신/강감찬/유관순";
        // st는 토큰화된 문자열을 담는 StringTokenizer 객체
        StringTokenizer st = new StringTokenizer(text, "/");
        // 토큰 수 확인
        int countToken = st.countTokens();
        System.out.println("토큰의 개수: " + countToken); // 토큰의 개수를 출력
        // 토큰이 있는지 확인
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }
}
