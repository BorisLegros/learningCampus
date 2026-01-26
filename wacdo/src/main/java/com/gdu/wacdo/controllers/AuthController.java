package com.gdu.wacdo.controllers;

import com.gdu.wacdo.services.CollaborateurService;
import com.gdu.wacdo.services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/public")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> credentials) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        credentials.get("username"),
                        credentials.get("password")
                )
        );

        String token = jwtService.generateToken(credentials.get("username"));
        return Map.of("token", token);
    }
}
