package oopClass.sec15;

public class PersonMain {
    public static void main(String[] args) {
        Person p1 = new Person("123456-1234567", "Kim", "abc");

        System.out.println(p1.nationality);
        System.out.println(p1.name);
        System.out.println(p1.ssn);

        // p1.nationality = "USA"; // This line will cause a compile time error
    }
}
