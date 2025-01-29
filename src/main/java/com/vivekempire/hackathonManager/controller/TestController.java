package com.vivekempire.hackathonManager.controller;

import com.vivekempire.hackathonManager.entitiy.CustomUser;
import com.vivekempire.hackathonManager.repository.CustomUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private CustomUserRepository customUserRepository;

    @GetMapping("/test_db")
    public String testDb(){
        CustomUser user=CustomUser.builder().email("vivek@gmail.com").role("admin").hashed_password("1234").last_logined_at(LocalDateTime.now()).build();
        System.out.println(user);
        customUserRepository.save(user);
        return "Ok";
    }
}
