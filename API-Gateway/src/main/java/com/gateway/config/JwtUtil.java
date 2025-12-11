package com.gateway.config;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;
@Component
public class JwtUtil {
    private final String SECRET = "7ca58d9c6f3ab1f4c875e19d39b7ac543e2d5c99fa93d1210f07b9e9de2ab47e";

    public Claims extractClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET.getBytes())
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean isTokenValid(String token) {
        try {
            extractClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String extractRole(String token) {
        return extractClaims(token).get("role", String.class);
    }

    public String extractUserId(String token) {
        return extractClaims(token).get("id", String.class);
    }

    public String extractUsername(String token) {
        return extractClaims(token).get("username", String.class);
    }
}
