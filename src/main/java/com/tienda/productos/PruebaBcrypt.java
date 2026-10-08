package com.tienda.productos;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PruebaBcrypt {
    public static void main(String[] args) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();

        String hash1 = encoder.encode("1234");
        String hash2 = encoder.encode("1234");

        System.out.println(hash1);
        System.out.println(hash2);
        System.out.println(encoder.matches("1234", hash1));
        System.out.println(encoder.matches("0000", hash1));
    }
}