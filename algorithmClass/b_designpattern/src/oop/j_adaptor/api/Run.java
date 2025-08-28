package oop.j_adaptor.api;

import oop.j_adaptor.user.UserController;
import oop.j_adaptor.auth.AuthService;

public class Run {

    public static void main(String[] args) {
        UserController userController = new UserController(new AuthService());
        String response = userController.googleLogin();

    }
}
