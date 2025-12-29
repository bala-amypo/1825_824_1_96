package com.example.demo.security;

import com.example.demo.model.UserAccount;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.nio.charset.StandardCharsets;
import java.security.Key;


@Component
public class JwtTokenProvider{

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration}")
    private long jwtExpiration;

    private Key getSigningKey(){
        return Keys.hmacShaKeyFor(jwtSecret.getBytes(StandardCharsets.UTF_8));
    }
    public String generateToken(String email){
        return Jwts.builder()
               .setSubject(email)
               .setIssuedAt(new Date())
               .setExpiration(new Date(System.currentTimeMillis() + jwtExpiration))
               .signWith(getSigningKey(), SignatureAlgorithm.HS512)
               .compact();
    }
    public String generateToken(UserAccount user){
        return Jwts.builder()
               .setSubject(user.getEmail())
               .claim("userId", user.getId())
               .claim("role", user.getRole())
               .setIssuedAt(new Date())
               .setExpiration(new Date(System.currentTimeMillis()+jwtExpiration))
               .signWith(getSigningKey(), SignatureAlgorithm.HS512)
               .compact();
    }
    private Claims getClaims(String token){
        return Jwts.parserBuilder()
               .setSigningKey(getSigningKey())
               .build()
               .parseClaimsJws(token)
               .getBody();
    }
    public String getEmail(String token){
        return getClaims(token).getSubject();
    }
    public String getRole(String token){
        Object role = getClaims(token).get("role");
        return role != null ? role.toString() : null;
    }
    public Long getUserId(String token){
        Object id = getClaims(token).get("userId");
        return id != null ? Long.parseLong(id.toString()) : null;
    }
    public boolean validateToken(String token){
        try{
            getClaims(token);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}