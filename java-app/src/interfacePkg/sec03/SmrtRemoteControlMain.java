package interfacePkg.sec03;

public class SmrtRemoteControlMain {
    public static void main(String[] args) {
        SmartTelevision stv = new SmartTelevision();

        stv.turnOn(); // IRemoteControl 인터페이스의 turnOn() 메서드 호출
        stv.setVolume(5); // 볼륨을 5로 설정
        stv.search("www.example.com"); // ISearchable 인터페이스의 search()

        IRemoteControl rc = new SmartTelevision();
        rc.turnOn(); // IRemoteControl 인터페이스의 turnOn() 메서드 호출
        ISearchable se = new SmartTelevision();
        se.search("www.example.com"); // ISearchable 인터페이스의 search() 메서드 호출
    }
}
