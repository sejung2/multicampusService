package multiThread.sec03;

public class BeepThreadEx {
    public static void main(String[] args) {
        // 사용자 정의 thread 클래스
        Thread thread = new BeepThread();
        thread.start(); // 작업 1

        thread.start(); // 작업 3 , 스레드 새로 생성없이 start() 하면 오류 - start()는 한 스레드 당 한번만 호출 가능

        // 작업 2
        for (int i = 0; i < 5; i++) {
            System.out.println("띵");
            try {
                Thread.sleep(500); // 0.5초 대기
            } catch (Exception e) {
            }
        }

    }
}
