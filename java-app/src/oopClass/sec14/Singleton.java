package oopClass.sec14;

public class Singleton {
    // 싱글톤 패턴을 구현하기 위한 클래스
    // 하나의 애플리케이션 내에서 단 하나의 인스턴스만 존재하도록 보장하는 패턴
    private static Singleton singleton = new Singleton();

    // 생성자를 private으로 선언하여 외부에서 인스턴스를 생성하지 못하도록 함
    private Singleton() {}

    // static 메서드를 통해 유일한 인스턴스를 반환
    public static Singleton getInstance() {
        return singleton; // 위에서 생성한 인스턴스를 반환
    }
}
