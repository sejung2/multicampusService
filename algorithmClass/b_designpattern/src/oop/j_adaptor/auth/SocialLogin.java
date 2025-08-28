package oop.j_adaptor.auth;

import oop.j_adaptor.user.UserProfile;

public interface SocialLogin {
    UserProfile login(String token);
}
