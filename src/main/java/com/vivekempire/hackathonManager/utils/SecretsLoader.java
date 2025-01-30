package com.vivekempire.hackathonManager.utils;

import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.util.Properties;

@Component
public class SecretsLoader {

    private String emailSender,emailPassword,JwtSecret,emailHost,emailPort;

    SecretsLoader() throws Exception{
        FileReader reader =new FileReader("src/main/resources/secret.properties");
        Properties properties=new Properties();
        properties.load(reader);
        this.emailHost=properties.getProperty("emailHost");
        this.emailPassword=properties.getProperty("emailPassword");
        this.emailPort=properties.getProperty("emailPort");
        this.JwtSecret=properties.getProperty("JWT_SECRET");
        this.emailSender=properties.getProperty("emailUsername");
    }

    public String getEmailSender() {
        return emailSender;
    }


    public String getEmailPassword() {
        return emailPassword;
    }



    public String getJwtSecret() {
        return JwtSecret;
    }


    public String getEmailHost() {
        return emailHost;
    }



    public String getEmailPort() {
        return emailPort;
    }

}


