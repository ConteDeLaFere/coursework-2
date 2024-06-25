package com.malina.spring.coursework2.controller;

import com.malina.spring.coursework2.model.Question;
import com.malina.spring.coursework2.service.interfaces.ExaminerService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/examiner")
public class ExaminerController {

    private final ExaminerService examinerService;

    public ExaminerController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/questions")
    public Collection<Question> getQuestions(@RequestParam int amount) {
        return examinerService.getQuestions(amount);
    }

}
