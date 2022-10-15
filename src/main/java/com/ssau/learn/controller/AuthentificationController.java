package com.ssau.learn.controller;

import com.ssau.learn.dao.UserRepository;
import com.ssau.learn.entity.Role;
import com.ssau.learn.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;
import com.ssau.learn.security.msg.rs.JwtResponse;
import com.ssau.learn.security.msg.rq.LoginRequest;
import com.ssau.learn.security.msg.rq.SignupRequest;
import com.ssau.learn.security.msg.rs.MessageResponse;
import com.ssau.learn.security.services.UserDetailsImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.ssau.learn.security.jwt.JwtUtils;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthentificationController {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        String role = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority)
                .findFirst().orElse(null);

        return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(),
                userDetails.getEmail(), role));
    }

    @PostMapping(value = "/registered")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signupRequest){
        if (userRepository.existsByLoginOrEmail(signupRequest.getLogin(), signupRequest.getEmail())){
            return ResponseEntity.badRequest().body(new MessageResponse("Invalid login or email"));
        }

        User user = new User(signupRequest.getLogin(), signupRequest.getEmail(), encoder.encode(
                signupRequest.getPassword()), Role.ROLE_USER);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully"));
    }
}
