package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class UserAuthTest {

    @Test
    public void test1() {
        UserAuthenction valid = new UserAuthenction();
        assertEquals("User successfully login", valid.userValid("tom", "tom123"));
    }

    @Test
    public void test2() {
        UserAuthenction valid = new UserAuthenction();
        assertEquals("Enter correct username and password", valid.userValid("sam", "tom123"));
    }
}
