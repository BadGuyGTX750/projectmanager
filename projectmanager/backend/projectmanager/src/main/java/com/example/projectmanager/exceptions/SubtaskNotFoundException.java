package com.example.projectmanager.exceptions;

import org.springframework.data.jpa.repository.JpaRepository;

public class SubtaskNotFoundException extends RuntimeException {
    public SubtaskNotFoundException(String message) {
        super(message);
    }
}
