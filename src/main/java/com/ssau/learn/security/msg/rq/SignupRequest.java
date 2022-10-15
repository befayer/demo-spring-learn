package com.ssau.learn.security.msg.rq;

import com.ssau.learn.entity.Role;
import lombok.Data;

@Data
public class SignupRequest {
    private String login;
    private String email;
    private String password;
    private Role role;
}
