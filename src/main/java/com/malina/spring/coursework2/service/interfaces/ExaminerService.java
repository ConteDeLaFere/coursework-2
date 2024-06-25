package com.malina.spring.coursework2.service.interfaces;

import com.malina.spring.coursework2.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
