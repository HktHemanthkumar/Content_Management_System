package com.app.content.Controller;

import com.app.content.Repository.UserRepo;
import com.app.content.dto.LoginRequest;
import com.app.content.dto.SignupRequest;
import com.app.content.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@Validated
public class AuthController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private com.app.content.config.JwtUtil jwtUtil;

    /* ---------- SIGN‑UP ---------- */
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest req) {
        if (userRepo.findByEmail(req.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Email already exists");
        }

        User c = new User();
        c.setUsername(req.getUsername());
        c.setEmail(req.getEmail());
        c.setPassword(encoder.encode(req.getPassword()));

        userRepo.save(c);
        return ResponseEntity.ok("Signup successful");
    }

    /* ---------- LOG‑IN ---------- */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req) {
        User c = userRepo.findByEmail(req.getEmail())
                .orElse(null);

        if (c == null || !encoder.matches(req.getPassword(), c.getPassword())) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
        String token = jwtUtil.generateToken(c.getEmail());
        return ResponseEntity.ok(Map.of("token", token));
    }
}
