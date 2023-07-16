package com.example;

public class UserAuthenction {
    String username = "tom";
    String password = "tom123";

    public String userValid(String user, String pass) {
        if (user.equals(username) && pass.equals(password)) {
            System.out.println("User successfully login");
            return "User successfully login";
        } else {
            return "Enter correct username and password";
        }
    }
}
