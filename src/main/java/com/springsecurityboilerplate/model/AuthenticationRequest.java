package com.springsecurityboilerplate.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Abdur Rahim Nishad
 * @created 09/02/2021 - 11:56 PM
 * @project springsecurity
 */
@Data
public class AuthenticationRequest implements Serializable {
    private String email;
    private String password;
    public AuthenticationRequest(String email, String password) {
        this.setEmail(email);
        this.setPassword(password);
    }
}
