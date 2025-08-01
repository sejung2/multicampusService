package genericCollection.sec04;

public class UtilMain {
    public static void main(String[] args) {
        // Util class's static method
        // Util class's boxing method, that returns a Box<T> object
        // when method is called, the type parameter T is inferred from the argument type
        Box<Integer> box1 = Util.boxing(100);// returns Box<Integer>
        int intValue = box1.get();

        Box<String> box2 = Util.boxing("홍길동");
        String strValue = box2.get();

        System.out.println("Integer Value: " + intValue);
        System.out.println("String Value: " + strValue);
    }
}
