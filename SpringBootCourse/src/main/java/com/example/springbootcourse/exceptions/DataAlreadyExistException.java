package com.example.springbootcourse.exceptions;

public class DataAlreadyExistException extends RuntimeException{

    public DataAlreadyExistException(String message) {
        super(message);
    }
}