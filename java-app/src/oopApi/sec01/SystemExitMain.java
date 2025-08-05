package oopApi.sec01;

public class SystemExitMain {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            if (i == 5) {
                System.exit(0); // 프로그램을 강제 종료
                break;
            }
        }
        System.out.println("종료");
    }
}
