package com.vivekempire.hackathonManager;

import com.vivekempire.hackathonManager.entitiy.CustomUser;
import com.vivekempire.hackathonManager.repository.CustomUserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import java.time.LocalDateTime;

@SpringBootApplication
@EnableAsync
public class HackathonManagerApplication {

	public static void main(String[] args) {

		SpringApplication.run(HackathonManagerApplication.class, args);



	}

}
