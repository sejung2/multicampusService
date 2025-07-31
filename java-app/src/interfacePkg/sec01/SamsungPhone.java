package interfacePkg.sec01;

public class SamsungPhone implements ISmartPhone {
    String name;

    public SamsungPhone() {
        name = "Samsung Galaxy";
    }

    @Override
    public void sendCall() {
        System.out.println(name + "에서 전화 걸기");
    }

    @Override
    public void receiveCall() {
        System.out.println(name + "에서 전화 받기");
    }

    @Override
    public void sendSMS() {

    }

    @Override
    public void receiveSMS() {

    }
}
