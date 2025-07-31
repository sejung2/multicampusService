package interfacePkg.sec03;

public interface IRemoteControl {
    int MAX_VOLUME = 10; // 상수는 public static final이 생략되어 있음
    int MIN_VOLUME = 0; // 상수는 public static final이 생략되어

    // 추상 메서드는 public abstract가 생략되어 있음
    void turnOn(); // TV를 켜는 메서드
    void turnOff(); // TV를 끄는 메서드
    void setVolume(int volume); // 볼륨을 설정하는 메서드

    // 디폴트 메서드
    default void setMute(boolean mute) {
        if (mute) {
            System.out.println("음소거 기능이 켜졌습니다.");
        } else {
            System.out.println("음소거 기능이 꺼졌습니다.");
        }
    }
    // 정적 메서드
    static void showRemote() {
        System.out.println("static 메소드가 인터페이스에서 구현");
    }

    static void changeBattery() {
        System.out.println("리모컨 배터리를 교체합니다.");
    }
}
