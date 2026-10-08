package com.tienda.productos;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

    // Clave secreta del servidor (en producción iría en una variable de entorno)
    private final SecretKey clave = Keys.hmacShaKeyFor(
            "mi-clave-secreta-super-larga-para-firmar-tokens-jwt-123456".getBytes()
    );

    private final long expiracionMs = 3600000; // 1 hora

    public String generarToken(String username, String rol) {
        return Jwts.builder()
                .subject(username)
                .claim("rol", rol)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + expiracionMs))
                .signWith(clave)
                .compact();
    }
    public io.jsonwebtoken.Claims validar(String token) {
        return Jwts.parser()
                .verifyWith(clave)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}