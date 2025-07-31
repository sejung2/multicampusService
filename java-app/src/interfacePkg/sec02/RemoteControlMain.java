package interfacePkg.sec02;

public class RemoteControlMain {
    public static void main(String[] args) {

        IRemoteControl rc = null;

        rc = new Television();
        rc.turnOn(); // 인터페이스 추상 메서드 호출 : 재정의
        rc.turnOff();
        rc.setVolume(5);
        rc.setMute(true);
        rc.setMute(false);

        System.out.println("-------------------------");

        // Audio 객체 생성
        rc = new Audio();
        rc.turnOn(); // 인터페이스 추상 메서드 호출 : 재정의
        rc.turnOff();
        rc.setVolume(7);
        rc.setMute(true);
        rc.setMute(false); // 디폴트메서드 재정의하지 않았음 interface의 기본 메서드 호출

        IRemoteControl.changeBattery();
        //rc.showRemote(); // 인터페이스의 정적 메서드여도 인터페이스 참조 변수를 통해서 접근은 불가능
    }
}
