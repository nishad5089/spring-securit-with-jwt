package com.springsecurityboilerplate.springsecurity.exception;

/**
 * @author Abdur Rahim Nishad
 * @created 10/02/2021 - 12:35 AM
 * @project springsecurity
 */
public class UserNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1348771109171435607L;

    public UserNotFoundException(String message) {
        super(message);
    }
}
