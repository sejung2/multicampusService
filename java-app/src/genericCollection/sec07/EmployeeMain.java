package genericCollection.sec07;

import java.util.ArrayList;
import java.util.Iterator;

public class EmployeeMain {
    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<>();

        Employee e1 = new Employee(100, "이대리", 1000);
        Employee e2 = new Employee(101, "김대리", 3000);

        list.add(e1);
        list.add(e2);
        list.add(new Employee(102, "박대리", 2000));

        for (Employee employee : list) {
            System.out.println("사원번호: " + employee.getId() + ", 이름: " + employee.getName() + ", 급여: " + employee.getSalary());
        }

        Iterator<Employee> it = list.iterator();
        System.out.println("Iterator를 사용한 출력:");
        while (it.hasNext()) {
            Employee employee = it.next();
            System.out.println("사원번호: " + employee.getId() + ", 이름: " + employee.getName() + ", 급여: " + employee.getSalary());
        }
    }
}

