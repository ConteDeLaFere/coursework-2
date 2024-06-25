package com.malina.spring.coursework2.service.implmentations;

import com.malina.spring.coursework2.exception.IllegalAmountOfQuestionsException;
import com.malina.spring.coursework2.model.Question;
import com.malina.spring.coursework2.service.interfaces.ExaminerService;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final JavaQuestionService javaQuestionService;

    public ExaminerServiceImpl(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        int size = javaQuestionService.getAll().size();
        List<Question> randomQuestions = new ArrayList<>(amount);
        if (amount <= 0 || amount > size) {
            throw new IllegalAmountOfQuestionsException();
        }

        if (amount == size) {
            return javaQuestionService.getAll();
        }

        while (randomQuestions.size() < amount) {
            Question question = javaQuestionService.getRandomQuestion();
            if (!randomQuestions.contains(question)) {
                randomQuestions.add(question);
            }
        }

        return randomQuestions;
    }
}
