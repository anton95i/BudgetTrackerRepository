package com.backendbudgettracker.backendbudgettracker.security;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;

//import com.backendbudgettracker.backendbudgettracker.entity.User;

import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j // Lombok - instead of Logger
public class JwtTokenProvider {

    @Value("${app.jwtSecret}")
    private String jwtSecret;

    public String generateToken(String userEmail) {
        Instant now = Instant.now();
        Instant expiration = now.plus(24, ChronoUnit.HOURS);

        return Jwts.builder()
                .setSubject(userEmail)
                .setIssuedAt(java.util.Date.from(now))
                .setExpiration(java.util.Date.from(expiration))
                .signWith(io.jsonwebtoken.SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String generateToken(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return generateToken(user.getUsername());
    }

    public String getEmailFromJWT(String token) {
        Claims claims = Jwts
                .parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (io.jsonwebtoken.MalformedJwtException e) {
            log.error("Invalid JWT signature.");
        } catch (io.jsonwebtoken.ExpiredJwtException e) {
            log.error("Expired JWT token.");
        } catch (io.jsonwebtoken.UnsupportedJwtException e) {
            log.error("Unsupported JWT token.");
        } catch (IllegalArgumentException e) {
            log.error("JWT token compact of handler are invalid.");
        }
        return false;
    }

}
