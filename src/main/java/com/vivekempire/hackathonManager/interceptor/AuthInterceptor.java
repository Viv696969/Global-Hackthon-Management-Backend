package com.vivekempire.hackathonManager.interceptor;

import com.vivekempire.hackathonManager.utils.JwtAuthenticationUtility;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.PrintWriter;
import java.util.Map;

public class AuthInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtAuthenticationUtility jwtAuthenticationUtility;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token=request.getHeader("Authorization");
        if (token==null || !token.startsWith("Bearer ")){
            response.setStatus(401);
            PrintWriter writer=response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            writer.write("{\"error\": \"No token passed!\"}");
            return false;
        }
        token=token.substring(7);
        Map<String,Object> data=jwtAuthenticationUtility.isTokenValid(token);
        if ((boolean)data.get("status")){
            request.setAttribute("id",data.get("id"));
            request.setAttribute("role",data.get("role"));
            return true;
        }
        response.setStatus(401);
        PrintWriter writer=response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        writer.write("{\"error\": \"Token exipired!\"}");
        return false;

    }
}
