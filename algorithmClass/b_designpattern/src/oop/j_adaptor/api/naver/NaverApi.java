package oop.j_adaptor.api.naver;

public class NaverApi {

    public NaverProfile getProfile(String token) {
        return new NaverProfile("seing_naver", "aaa@ccc.com");
    }
}
