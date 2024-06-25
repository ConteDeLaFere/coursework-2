package com.malina.spring.coursework2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuestionAlreadyAdded extends RuntimeException {
    public QuestionAlreadyAdded() {}
}
