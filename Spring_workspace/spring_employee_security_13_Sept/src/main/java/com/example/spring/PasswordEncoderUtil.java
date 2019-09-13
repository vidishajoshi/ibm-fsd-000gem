package com.example.spring;

import java.util.logging.Logger;

//import org.hibernate.annotations.common.util.impl.Log_.logger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderUtil {
    public static void main(String[] args) {
    //	Logger log=new Logger();
    	
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encoded = encoder.encode("root");//bob's password
        System.out.println(encoded);
        encoded = encoder.encode("root");//sara's password
        System.out.println(encoded);
    }
}
