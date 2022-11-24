package com.example.coderhousespring.exceptions;

public class AuthErrorException extends RuntimeException {
    public AuthErrorException(String msg) {
        super(msg);
    }
}
