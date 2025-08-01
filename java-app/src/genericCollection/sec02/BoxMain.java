package genericCollection.sec02;

public class BoxMain {
    public static void main(String[] args) {
        Box<String> box1 = new Box<>();
        box1.set("hello");
        String str = box1.get();
        System.out.println(str);

        Box<Integer> box2 = new Box<>();
        box2.set(17);
        int no = box2.get();
        System.out.println(no);
    }
}
