package com.malina.spring.coursework2;

import com.malina.spring.coursework2.exception.QuestionAlreadyAdded;
import com.malina.spring.coursework2.exception.QuestionNotFound;
import com.malina.spring.coursework2.model.Question;
import com.malina.spring.coursework2.service.implmentations.JavaQuestionService;
import com.malina.spring.coursework2.service.interfaces.QuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JavaQuestionsTests {

    private QuestionService javaQuestionService;

    @BeforeEach
    public void setUp() {
        javaQuestionService = new JavaQuestionService();
        javaQuestionService.add("Какой объем в памяти занимает тип double?", "8 байт");
        javaQuestionService.add("Какие существуют принципы ООП?", "Инкапсуляция, наследование, полиморфизм, абстракция");
        javaQuestionService.add("Для чего нужна конструкция try-catch?", "Для обработки исключений");
    }

    @Test
    public void addQuestionTest() {
        Question question = new Question("Что такое локальная переменная?", "Переменная, которая объявлена внутри метода");
        javaQuestionService.add(question);
        assertEquals(4, javaQuestionService.getAll().size());
    }

    @Test
    public void removeQuestionTest() {
        Question question = new Question("Какой объем в памяти занимает тип double?", "8 байт");
        javaQuestionService.remove(question);
        assertEquals(2, javaQuestionService.getAll().size());
    }

    @Test
    public void getAllQuestionsTest() {
        List<Question> expected = List.of(
                new Question("Какой объем в памяти занимает тип double?", "8 байт"),
                new Question("Какие существуют принципы ООП?", "Инкапсуляция, наследование, полиморфизм, абстракция"),
                new Question("Для чего нужна конструкция try-catch?", "Для обработки исключений")
        );

        assertEquals(expected, javaQuestionService.getAll());
    }

    @Test
    public void addExistingQuestionTest() {
        assertThrows(QuestionAlreadyAdded.class, () -> javaQuestionService.add("Какой объем в памяти занимает тип double?", "8 байт"));
    }

    @Test
    public void notFoundQuestionTest() {
        Question question = new Question("Что такое локальная переменная?", "Переменная, которая объявлена внутри метода");
        assertThrows(QuestionNotFound.class, () -> javaQuestionService.remove(question));
    }
}
