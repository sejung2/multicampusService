package genericCollection.sec15;

import java.util.Objects;

public class Student {
    // Map key
    private int stdNo;
    private String stdName;

    public Student(int stdNo, String stdName) {
        this.stdNo = stdNo;
        this.stdName = stdName;
    }

    public int getStdNo() {
        return stdNo;
    }

    public void setStdNo(int stdNo) {
        this.stdNo = stdNo;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    @Override
    public int hashCode() {
        return stdName.hashCode() + stdNo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return stdNo == student.stdNo && Objects.equals(stdName, student.stdName);
    }
}
