package com.example.berryshoes.security;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
//
//    @Value("${jwt.secret}")
//    private String jwtSecret;
//
//    @Value("${jwt.accessTokenExpiration}")
//    private Long accessTokenExpiration;
//
//    @Value("${jwt.refreshTokenExpiration}")
//    private Long refreshTokenExpiration;
//
//    // Tạo Access Token
//    public String generateAccessToken(String subject, Map<String, Object> claims) {
//        return Jwts.builder()
//                .setClaims(claims)
//                .setSubject(subject)
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + accessTokenExpiration))
//                .signWith(SignatureAlgorithm.HS256, jwtSecret)
//                .compact();
//    }
//
//    // Tạo Refresh Token
//    public String generateRefreshToken(String subject) {
//        return Jwts.builder()
//                .setSubject(subject)
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + refreshTokenExpiration))
//                .signWith(SignatureAlgorithm.HS256, jwtSecret)
//                .compact();
//    }
//
//    // Kiểm tra tính hợp lệ của token
//    public Boolean validateToken(String token, String subject) {
//        final String username = extractUsername(token);
//        return (username.equals(subject) && !isTokenExpired(token));
//    }
//
//    public String extractUsername(String token) {
//        return extractClaim(token, Claims::getSubject);
//    }
//
//    public Date extractExpiration(String token) {
//        return extractClaim(token, Claims::getExpiration);
//    }
//
//    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
//        final Claims claims = extractAllClaims(token);
//        return claimsResolver.apply(claims);
//    }
//
//    private Claims extractAllClaims(String token) {
//        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
//    }
//
//    private Boolean isTokenExpired(String token) {
//        return extractExpiration(token).before(new Date());
//    }
}
