package oop.j_adaptor.user;

import oop.j_adaptor.auth.AuthService;
import oop.j_adaptor.auth.SocialLoginProvider;

public class UserController {

    private final AuthService authService;

    public UserController(AuthService authService) {
        this.authService = authService;
    }

    public String googleLogin() {
        authService.socialLogin(SocialLoginProvider.GOOGLE, "abc");
        return "200 OK";
    }

    public String naverLogin() {
        authService.socialLogin(SocialLoginProvider.NAVER, "abc");
        return "200 OK";
    }

}
