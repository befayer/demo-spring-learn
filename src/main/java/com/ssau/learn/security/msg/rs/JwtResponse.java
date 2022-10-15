package com.ssau.learn.security.msg.rs;

import com.ssau.learn.entity.Role;
import lombok.Data;

@Data
public class JwtResponse {
    private String token;

    private String type = "Bearer";
    private int id;
    private String username;
    private String email;
    private String role;

    public JwtResponse(String accessToken, int id, String username, String email, String role) {
        this.token = accessToken;
        this.id = id;
        this.username = username;
        this.email = email;
        this.role = role;
    }
}
