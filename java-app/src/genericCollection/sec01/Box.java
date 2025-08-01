package genericCollection.sec01;

public class Box {
    // 필드 1개와 getter/setter가 필요
    // 어떤 타입의 필드인지는 사용자가 결정할 수 있도록 제네릭 타입으로 선언
    private Object object;

    public void set(Object object) {
        this.object = object;
    }

    public Object get() {
        return object;
    }

}
