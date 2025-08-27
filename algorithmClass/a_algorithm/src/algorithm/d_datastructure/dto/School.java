package algorithm.d_datastructure.dto;

import java.util.Objects;

public class School implements Comparable<School>{

    private String name;
    private String address;
    private String level;

    public School(String name, String address, String level) {
        this.name = name;
        this.address = address;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", level='" + level + '\'' +
                '}';
    }

    @Override
    public int compareTo(School o) {
//        // 레벨을 기준으로 오름차순, 대학이 같다면 이름으로 내림차순 정렬
        // this.name.equals(o.name)
        if (this.level.compareTo(o.level) == 0){
            return this.name.compareTo(o.name) * -1;
        }
        return this.level.compareTo(o.level);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        School school = (School) o;
        return Objects.equals(name, school.name) && Objects.equals(address, school.address) && Objects.equals(level, school.level);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, level);
    }
}
