package com.vivekempire.hackathonManager.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtAuthenticationUtility {

    private String JwtKey;
    private long expirationTime= Duration.ofDays(30).toMillis();

    public JwtAuthenticationUtility(SecretsLoader loader){
        this.JwtKey=loader.getJwtSecret();
    }

    public String generateToken(Map<String,String> data){

        String token= Jwts.builder()
                .setClaims(data)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+expirationTime))
                .signWith(SignatureAlgorithm.HS256, JwtKey)
                .compact();

        return token;
    }

    public Claims getDataBody(String token){

        return Jwts.parserBuilder().setSigningKey(JwtKey).build().parseClaimsJws(token).getBody();
    }

    public Map<String,Object> isTokenValid(String token){
        Map<String,Object> data=new HashMap<>();
        Claims body=getDataBody(token);
        if (body.getExpiration().after(new Date())){
            data.put("status",true);
            data.put("id",body.get("id"));
            data.put("role",body.get("role"));
            return data;
        }
        data.put("status",false);
        return data;
    }


}
