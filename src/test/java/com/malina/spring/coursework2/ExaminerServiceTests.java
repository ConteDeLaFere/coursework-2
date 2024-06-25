package com.malina.spring.coursework2;

import com.malina.spring.coursework2.exception.IllegalAmountOfQuestionsException;
import com.malina.spring.coursework2.model.Question;
import com.malina.spring.coursework2.service.implmentations.ExaminerServiceImpl;
import com.malina.spring.coursework2.service.implmentations.JavaQuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceTests {

    @Mock
    private JavaQuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    private final List<Question> questions = List.of(
            new Question("Какой объем в памяти занимает тип double?", "8 байт"),
            new Question("Какие существуют принципы ООП?", "Инкапсуляция, наследование, полиморфизм, абстракция"),
            new Question("Для чего нужна конструкция try-catch?", "Для обработки исключений")
    );

    @Test
    public void getQuestionsTest1() {
        Mockito.when(questionService.getAll()).thenReturn(questions);
        Collection<Question> result = examinerService.getQuestions(2);
        assertEquals(2, result.size());
    }

    @Test
    public void getQuestionsTest2() {
        Mockito.when(questionService.getAll()).thenReturn(questions);
        assertThrows(IllegalAmountOfQuestionsException.class, () -> examinerService.getQuestions(5));
    }
}
