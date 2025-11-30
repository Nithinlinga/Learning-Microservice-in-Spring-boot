package com.gateway.config;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;
@Component
public class JwtUtil {
    private final String SECRET = "vbooking1234567890vbooking1234567890";

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
