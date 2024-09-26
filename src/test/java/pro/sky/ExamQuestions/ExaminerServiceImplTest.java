package pro.sky.ExamQuestions;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;
import java.util.stream.IntStream;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static pro.sky.ExamQuestions.JavaQuestionService.RANDOM;


@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {


    @Mock
    private QuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl  examinerService;

    @ParameterizedTest
    @ValueSource(ints = {5, 10})
    void getQuestionsTest(int amount){
        Collection<Question> questionCollection = IntStream.generate(RANDOM::nextInt)
                .limit(amount)
                .boxed()
                .map(Object::toString)
                .map(s -> new Question(s, s))
                .toList();

        when(questionService.getAll())
                .thenReturn(questionCollection);


        when(questionService.getRandomQuestion())
                .thenAnswer(invocation ->
                        new Question(
                                RANDOM.nextLong() + " ",
                                RANDOM.nextLong() + " "
                        ));

        Collection<Question> actualQuestions = examinerService.getQuestions(amount);
        assertEquals(amount,actualQuestions.size());
        verify(questionService, atLeast(amount))
                .getRandomQuestion();


    }


    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void getQuestionsNegativeTest(int amount) {
        assertThrows(AmountOfQuestionsExceededException.class, () -> examinerService.getQuestions(amount));


    }

    @ParameterizedTest
    @ValueSource(ints = {6, 10})
    void getQuestionsNegativeTest2(int amount) {
        //given
        Collection<Question> questionCollection = IntStream.generate(RANDOM::nextInt)
                .limit(amount-1)
                .boxed()
                .map(Object::toString)
                .map(s -> new Question(s, s))
                .toList();
        when(questionService.getAll())
                .thenReturn(questionCollection);

        assertThrows(AmountOfQuestionsExceededException.class, () -> examinerService.getQuestions(amount));


    }

}