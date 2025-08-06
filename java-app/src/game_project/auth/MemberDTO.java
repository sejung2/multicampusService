package game_project.auth;

import java.util.Objects;

public class MemberDTO { // 회원 정보를 저장하는 DTO 클래스
    private String id; // 회원 아이디
    private String pass; // 회원 비밀번호
    private String name; // 회원 이름(닉네임)

    public MemberDTO(String id, String pass, String name) {
        this.id = id;
        this.pass = pass;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MemberDTO memberDTO = (MemberDTO) o;
        return Objects.equals(id, memberDTO.id) && Objects.equals(name, memberDTO.name); // 아이디와 이름이 같으면 동일인으로 간주
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pass, name);
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", pass='" + pass + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
