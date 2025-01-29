package com.vivekempire.hackathonManager.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PassWordEncoderUtility {

    @Autowired
    private BCryptPasswordEncoder encoder;

    public String encodePassWord(String password){
        return encoder.encode(password);
    }

    public boolean verifyPassword(String hashedPassword,String password){
        return  encoder.matches(password,hashedPassword);

    }
}
