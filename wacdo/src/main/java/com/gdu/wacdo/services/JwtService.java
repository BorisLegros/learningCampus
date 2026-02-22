package com.gdu.wacdo.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtService {

    //@Value("${JWT_SECRET}")
    private String SECRET_KEY = "3kF9mP2nQ5rS8tU1vW4xY7zA0bC6dE9fG2hJ5kL8mN1oP4qR7sT0uV3wX6yZ9aB2cD5eF8gH1iJ4kM7nO0pQ3rS6tU9vW2xY5zA8bC1dE4fG7hJ0kL3mN6oP9qR2sT5uV8wX1yZ4aB7cD0eE3fG6hH9iJ2kM5nO8pQ1rS4tU7vW0xY3zA6bC9dE2fG5hJ8kL1mN4oP7qR0sT3uV6wX9yZ2aB5cD8eF1gH4iJ7kM0nO3pQ6rS9tU2vW5xY8zA1bC4dE7fG0hJ3kL6mN9oP2qR5sT8uV1wX4yZ7aB0cD3eF6gH9iJ2kM5nO8pQ1rS4";

//    @Value("${JWT_EXPIRATION}")
    private long EXPIRATION_TIME = 86400000;

    public String generateToken(String username) {
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(getSigningKey())
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    public boolean isTokenValid(String token) {
        try {
            Jwts.parser().verifyWith(getSigningKey()).build().parseSignedClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private SecretKey getSigningKey() {
        byte[] keyBytes = SECRET_KEY.getBytes();
        return Keys.hmacShaKeyFor(keyBytes);
    }
}