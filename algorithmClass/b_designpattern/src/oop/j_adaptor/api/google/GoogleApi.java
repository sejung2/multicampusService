package oop.j_adaptor.api.google;

public class GoogleApi {

    public GoogleProfile getProfile(String token) {
        return new GoogleProfile("seing", "seing@seing.com");
    }
}
