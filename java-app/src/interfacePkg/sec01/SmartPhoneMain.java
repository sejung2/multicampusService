package interfacePkg.sec01;

public class SmartPhoneMain {
    public static void main(String[] args) {
        SamsungPhone sp = new SamsungPhone();
        sp.sendCall();

        //interface 참조 변수로 객체 생성
        ISmartPhone phone = new SamsungPhone();
        phone.sendCall();

        ISmartPhone iip = new IPhone();
        iip.sendCall();
    }
}
