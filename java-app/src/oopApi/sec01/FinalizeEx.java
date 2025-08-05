package oopApi.sec01;

public class FinalizeEx {
    public static void main(String[] args) {
        Count count = null;
        for (int i = 0; i < 50; i++) {
            count = new Count(i);
            count = null; // 객체를 null로 설정하여 가비지 컬렉션 대상이 되도록 함
            System.gc(); // 가비지 컬렉션을 요청 - 메모리가 모자라거나 CPU가 여유 있을 때 gc는 자동 실행됨
            try { //
                Thread.sleep(100); // 가비지 컬렉션이 실행될 시간을 주기
                // 이유: 가비지 컬렉션은 JVM이 자동으로 관리하는 메모리 회수 작업으로, 즉시 실행되지 않을 수 있음
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
