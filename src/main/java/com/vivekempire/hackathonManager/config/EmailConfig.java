package com.vivekempire.hackathonManager.config;

import com.vivekempire.hackathonManager.utils.SecretsLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class EmailConfig {

    @Autowired
    private SecretsLoader loader;

    @Bean
    public JavaMailSender getMailSender(){
        JavaMailSenderImpl javaMailSender=new JavaMailSenderImpl();
        javaMailSender.setHost(loader.getEmailHost());
        javaMailSender.setPassword(loader.getEmailPassword());
        javaMailSender.setUsername(loader.getEmailSender());
        javaMailSender.setPort(Integer.parseInt(loader.getEmailPort()));
        Properties props=javaMailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
        return javaMailSender;
    }
}
