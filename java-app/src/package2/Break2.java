package package2;

public class Break2 {
    public static void main(String[] args) {
//        // 중첩 반복일 때
//        for(char upper = 'A'; upper <= 'Z'; upper++) {
//            for(char lower = 'a'; lower <= 'z'; lower++) {
//                System.out.println(upper + " - " + lower);
//            }
//        }

        // 중첩 반복문에서 break 사용 - label 사용
        Outter:for(char upper = 'A'; upper <= 'Z'; upper++) {
            for(char lower = 'a'; lower <= 'z'; lower++) {
                System.out.println(upper + " - " + lower);
                if(lower =='g') break Outter; // Outter 레이블을 가진 반복문을 종료
            }
        }

        // 중첩 반복문에서 break 사용 - label 사용2
        Outter:for(char upper = 'A'; upper <= 'Z'; upper++) {
            for(char lower = 'a'; lower <= 'z'; lower++) {
                System.out.println(upper + " - " + lower);
                if(lower == 'g'){
                    break;
                }

                if(upper == 'K'){
                    break Outter;
                }
            }
        }
        System.out.println("프로그램 종료");
    }
}
