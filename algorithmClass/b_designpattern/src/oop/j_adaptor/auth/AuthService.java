package oop.j_adaptor.auth;

import oop.j_adaptor.api.google.GoogleApi;
import oop.j_adaptor.api.google.GoogleProfile;
import oop.j_adaptor.api.naver.NaverApi;
import oop.j_adaptor.api.naver.NaverProfile;
import oop.j_adaptor.auth.adaptor.GoogleAdaptor;
import oop.j_adaptor.auth.adaptor.NaverAdaptor;
import oop.j_adaptor.user.UserProfile;

public class AuthService {

    public void socialLogin(SocialLoginProvider provider, String token) {
        GoogleProfile profile = new GoogleApi().getProfile(token);

        SocialLogin socialLogin = switch (provider) {
            case NAVER -> new NaverAdaptor();
            case GOOGLE -> new GoogleAdaptor();
        };

        UserProfile userProfile = socialLogin.login(token);
        System.out.println(userProfile.username() + " 로그인 로직 시작");
    }
}
