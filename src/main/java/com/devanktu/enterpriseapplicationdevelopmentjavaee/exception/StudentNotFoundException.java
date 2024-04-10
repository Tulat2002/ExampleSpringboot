package com.devanktu.enterpriseapplicationdevelopmentjavaee.exception;

public class StudentNotFoundException extends RuntimeException{
    private static final long serialVerisionUID = 1;

    public StudentNotFoundException(String message) {
        super(message);
    }
}
