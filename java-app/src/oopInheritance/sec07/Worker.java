package oopInheritance.sec07;

public class Worker {
    private String joomiNo;
    private String name;


    public Worker(String joomiNo, String name) {
        this.joomiNo = joomiNo;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "joomiNo='" + joomiNo + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
