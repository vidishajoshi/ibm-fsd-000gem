package com.example.spring;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderUtil {
    public static void main(String[] args) {
    
    	
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encoded = encoder.encode("root");//mark's password
        System.out.println(encoded);
        encoded = encoder.encode("root");//admin's password
        System.out.println(encoded);
    }
}
