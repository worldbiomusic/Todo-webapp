package io.github.webapp.utility;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String digest = encoder.encode("adminpass");
        System.out.println(digest);
        digest = encoder.encode("adminpass");
        System.out.println(digest);
        digest = encoder.encode("adminpass");
        System.out.println(digest);
    }
}
