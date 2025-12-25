package com.example.demo.security;

import com.example.demo.model.UserAccount;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtTokenProvider {

    // ===== REQUIRED FIELD (tests inject value via reflection) =====
    private String jwtSecret;

    // ===== NO-ARG CONSTRUCTOR (MANDATORY) =====
    public JwtTokenProvider() {
    }

    // ===== TOKEN GENERATION =====
    public String generateToken(UserAccount user) {

        Key key = Keys.hmacShaKeyFor(jwtSecret.getBytes());

        return Jwts.builder()
                .setSubject(user.getId().toString())
                .claim("email", user.getEmail())
                .claim("role", user.getRole())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // 1 hour
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // ===== TOKEN VALIDATION =====
    public boolean validateToken(String token) {
        try {
            Key key = Keys.hmacShaKeyFor(jwtSecret.getBytes());
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // ===== GET EMAIL FROM TOKEN =====
    public String getEmail(String token) {
        return getClaims(token).get("email", String.class);
    }

    // ===== GET ROLE FROM TOKEN =====
    public String getRole(String token) {
        return getClaims(token).get("role", String.class);
    }

    // ===== GET USER ID FROM TOKEN =====
    public Long getUserId(String token) {
        Claims claims = getClaims(token);

        // Primary: subject
        if (claims.getSubject() != null) {
            return Long.valueOf(claims.getSubject());
        }

        // Fallback (safety)
        return claims.get("userId", Long.class);
    }

    // ===== HELPER METHOD =====
    private Claims getClaims(String token) {
        Key key = Keys.hmacShaKeyFor(jwtSecret.getBytes());
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
