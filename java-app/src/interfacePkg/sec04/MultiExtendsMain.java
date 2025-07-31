package interfacePkg.sec04;

public class MultiExtendsMain {
    public static void main(String[] args) {
        ImplementationC c = new ImplementationC();

        InterfaceA ia = c;
        ia.methodA();

        InterfaceB ib = c;
        ib.methodB();

        InterfaceC ic = c;
        ic.methodA();
        ic.methodB();
        ic.methodC();
    }
}
