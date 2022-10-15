package com.ssau.learn.security.msg.rq;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
