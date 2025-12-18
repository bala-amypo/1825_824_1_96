package com.example.demo.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class JwtTokenProvider{
    private final String SECRET="mysecretkey";
    private final long EXPIRATION=86400000;
    public String generateToken(String username){
        return Jwts.builder().setSubject(username).setExpiration(new Date(System.currentTimeMillis()+EXPIRATION)).signWith(SignatureAlgorithm.HS256, SECRET).compact();
    }
    public String extractUserName(String token){
        return Jwts.parser().setSigningKey(SECRET).parse
    }
}