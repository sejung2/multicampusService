package oopInheritance.sec03;

public class EmployeeMain {
    public static void main(String[] args) {
        EmployeeToString emp1 = new EmployeeToString("1234", "홍길동", "마케팅");
        EmployeeToString emp2 = new EmployeeToString("5678", "이몽룡", "영업부");

        System.out.println(emp1); // toString() 메서드가 자동 호출됨
        System.out.println(emp2);
    }
}
