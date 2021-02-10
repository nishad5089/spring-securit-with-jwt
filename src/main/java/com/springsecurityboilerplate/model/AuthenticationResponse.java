package com.springsecurityboilerplate.model;

import java.io.Serializable;

/**
 * @author Abdur Rahim Nishad
 * @created 09/02/2021 - 11:56 PM
 * @project springsecurity
 */
public class AuthenticationResponse implements Serializable {
    private final String jwt;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}
