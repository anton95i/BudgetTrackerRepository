package com.backendbudgettracker.backendbudgettracker.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.backendbudgettracker.backendbudgettracker.entity.User;
import com.backendbudgettracker.backendbudgettracker.repository.UserRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtHelper {

    @Value("${app.jwtSecret}")
    private String jwtSecret; // make this final !!!

    @Autowired
    private UserRepository userRepository;

    public Boolean getAdminFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");

        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            String jwt = bearerToken.substring(7);
            String email = getEmailFromJWT(jwt);
            User user = userRepository.findByEmail(email).get();
            return user.getAdmin();
        }
        return false;
    }

    public String getEmailFromJWT(String token) {
        Claims claims = Jwts
                .parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    public Long getUserIdFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");

        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            String jwt = bearerToken.substring(7);
            String email = getEmailFromJWT(jwt);
            User user = userRepository.findByEmail(email).get();
            return user.getId();
        }
        return null;
    }

}