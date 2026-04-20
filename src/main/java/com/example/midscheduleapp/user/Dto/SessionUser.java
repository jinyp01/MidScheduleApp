package com.example.midscheduleapp.user.Dto;

import lombok.Getter;

@Getter
public class SessionUser {

    private final Long id;
    private final String email;

    public SessionUser(Long id, String password) {
        this.id = id;
        this.email = password;
    }
}
