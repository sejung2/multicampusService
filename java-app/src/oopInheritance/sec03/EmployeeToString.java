package oopInheritance.sec03;

public class EmployeeToString {

    private  String empNo;
    private  String name;
    private  String department;

    public EmployeeToString(String empNo, String name, String department) {
        this.empNo = empNo;
        this.name = name;
        this.department = department;
    }

    @Override
    public String toString() {
        return "EmployeeToString{" +
                "empNo='" + empNo + '\'' +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
