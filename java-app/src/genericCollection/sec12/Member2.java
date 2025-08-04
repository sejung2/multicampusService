package genericCollection.sec12;

import java.util.Objects;

public class Member2 {
    public String name;
    public int age;

    public Member2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //Object 로부터 상속받은 hashCode() 메소드를 재정의
    // hashCode()는 객체의 참조값을 반환하는데 이 필드 값이 동일한 경우 동일한 값이 반환될 수 있도록 구현
    @Override
    public int hashCode() {
        //return name.hashCode() + age;
        return Objects.hash(name, age);
    }

    // Object로부터 상속받은 equals() 메소드를 재정의 -> 필드값이 어떤 상태일때 두 객체가 동등하다고 볼것인지
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Member2 member2 = (Member2) o;
        return age == member2.age && Objects.equals(name, member2.name);
    }
}
