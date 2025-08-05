package oopApi;

public class StringAPI {
    public static void main(String[] args) {
        String ssn = "880815-1234567";
        char sex = ssn.charAt(7); // 주민등록번호의 8번째 문자

        switch (sex) {
            case '1':
            case '3':
                System.out.println("남자입니다.");
                break;
            case '2':
            case '4':
                System.out.println("여자입니다.");
                break;
            default:
                System.out.println("잘못된 주민등록번호입니다.");
        }

        String title = "자바 프로그래밍";
        System.out.println(title.indexOf("프로그래밍")); // "프로그래밍"이 시작하는 인덱스 출력
        System.out.println(title.indexOf("java")); // "java"는 없으므로 -1 출력
        System.out.println(title.replace("자바", "Java")); // "자바"를 "Java"로 대체
        System.out.println(title.substring(3)); // 인덱스 3부터 끝까지의 문자열 추출
        System.out.println(title.substring(3, 6)); // 인덱스 3부터 6까지의 문자열 추출
        System.out.println(String.valueOf(true)); // boolean 값을 문자열로 변환
        System.out.println(title.split(" ")[0]);

        String str = "홍길동&이몽룡,성춘향,김자바-김길동";
        String[] names = str.split("&|,|-"); // 정규 표현식을 사용하여 구분자에 따라 문자열 분리
        System.out.println(names[2]);
        
    }
}
