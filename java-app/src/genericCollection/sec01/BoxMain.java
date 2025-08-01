package genericCollection.sec01;

public class BoxMain {
    public static void main(String[] args) {
        // Box 클래스 활용
        Box box = new Box();
        box.set("홍길동"); // set method의 매개변수 타입 Object, 인수는 String -> 자동 형변환
        // box 클래스의 object 필드에 String 타입의 객체가 저장됨
        String name = (String) box.get(); // get method의 반환 타입 Object, 반환값은 Object 타입이므로 String으로 형변환 필요
        System.out.println("이름: " + name);

        Box box2 = new Box();
        box2.set(7);
        int no = (int) box2.get(); // get method의 반환 타입 Object, 반환값은 Object 타입이므로 int로 형변환 필요
        System.out.println(no);
    }
}
