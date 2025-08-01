package genericCollection.sec04;

public class Util {
    // add member method: genericMethod
    public static <T> Box<T> boxing(T t) {
        Box<T> box = new Box<>();
        box.set(t);
        return box; // returns Box<T> object
    }
}
