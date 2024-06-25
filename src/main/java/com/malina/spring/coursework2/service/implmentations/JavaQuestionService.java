package com.malina.spring.coursework2.service.implmentations;

import com.malina.spring.coursework2.exception.QuestionAlreadyAdded;
import com.malina.spring.coursework2.exception.QuestionNotFound;
import com.malina.spring.coursework2.model.Question;
import com.malina.spring.coursework2.service.interfaces.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final List<Question> questions;

    public JavaQuestionService() {
        questions = new ArrayList<>();
    }

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        if (questions.contains(question)) {
            throw new QuestionAlreadyAdded();
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.contains(question)) {
            throw new QuestionNotFound();
        }
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableList(questions);
    }

    @Override
    public Question getRandomQuestion() {
        int count = questions.size();
        Random random = new Random();
        int number = random.nextInt(count);
        return questions.get(number);
    }
}
