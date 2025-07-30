package oopClass.sec15;

public class Person {
    final String nationality = "korean";
    String name;
    final String ssn;
    final String temp;

    public Person(String ssn, String name, String temp) {
        this.ssn = ssn; // the final field ssn must be initialized in the constructor
        this.name = name;
        this.temp = temp;
    }
}
