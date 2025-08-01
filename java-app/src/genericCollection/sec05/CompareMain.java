package genericCollection.sec05;

public class CompareMain {
    public static void main(String[] args) {
        Pair<Integer, String> p1 = new Pair<>(1, "사과");
        Pair<Integer, String> p2 = new Pair<>(1, "사과");

        boolean result1 = Util.compare(p1, p2);// Util class's static method compare

        if (result1) {
            System.out.println("p1 and p2 are equal");
        } else {
            System.out.println("p1 and p2 are not equal.");
        }

        Pair<String, String> p3 = new Pair<>("user1", "사과");
        Pair<String, String> p4 = new Pair<>("user2", "사과");
    }
}
