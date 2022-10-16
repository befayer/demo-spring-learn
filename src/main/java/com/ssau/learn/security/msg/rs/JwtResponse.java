package com.ssau.learn.security.msg.rs;

import lombok.Data;

@Data
public class JwtResponse {
    private String token;

    private String type = "Bearer";
    private int id;
    private String login;
    private String email;
    private String role;

    public JwtResponse(String accessToken, int id, String login, String email, String role) {
        this.token = accessToken;
        this.id = id;
        this.login = login;
        this.email = email;
        this.role = role;
    }
}
