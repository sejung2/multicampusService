package interfacePkg.sec04;

public class ImplementationC implements InterfaceC {



    @Override
    public void methodA() {
        System.out.println("ImplementationC의 methodA() 실행");
    }

    @Override
    public void methodB() {
        System.out.println("ImplementationC의 methodB() 실행");
    }

    @Override
    public void methodC() {
        System.out.println("ImplementationC의 methodC() 실행");
    }
}
