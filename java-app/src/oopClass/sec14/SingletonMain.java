package oopClass.sec14;

public class SingletonMain {
    public static void main(String[] args) {
        // Singleton 클래스의 인스턴스를 가져오는 예제
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();

        if (obj1 == obj2) {
            System.out.println("obj1과 obj2는 동일한 인스턴스입니다.");
        } else {
            System.out.println("obj1과 obj2는 다른 인스턴스입니다.");
        }
    }

}
