package pro.sky.ExamQuestions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {
    private final JavaQuestionService service = new JavaQuestionService();

    Set<Question> questionsJava = new HashSet<>(List.of(
            new Question ("Что такое Java?", " Это строго типизированный объектно-ориентированный язык программирования."),
            new Question("Кто разработал язык Java?", " Джеймс Гослинг."),
            new Question("В каком году была выпущена первая официальная версия — Java 1.0?", " В 1996 году."),
            new Question("Если Java - это кофе, то Bean - это...?", " Кофейное зерно."),
            new Question("Как изначально назывался язык Java?", " Oak («Дуб»).")));

    @Test
    @DisplayName("Добавляет вопрос/ответ")
    public void add (){
       //given
        String question = "Это вопрос";
        String answer = "А это ответ";
        //when
        Question added = service.add(question, answer);
       //then
        int actualSize = service.questionsJava.size();
        int expectedSize = service.questionsJava.size();
        //check
        assertEquals(expectedSize,actualSize);
        assertEquals(added.getQuestion(), question);
        assertEquals(added.getAnswer(), answer);
    }

    @Test
    @DisplayName("Выкидывает ошибку, если такой вопрос уже существует")
    public void noAdded() {
        //given
        String question = "Это вопрос";
        String answer = "А это ответ";
        //when
        Question added = service.add(question, answer);
        //then
        assertThrows(IllegalArgumentException.class, () -> service.add(question,answer));
    }

    @Test
    @DisplayName("Удаляет вопрос/ответ")
    public void remove (){
        //given
        String question = "Это вопрос";
        String answer = "А это ответ";
        int actualSize = service.questionsJava.size();
        //when
        Question added = service.add(question, answer);
        int actualSizeAfterAdded = service.questionsJava.size();
        //then
        Question removed = service.remove(new Question(question,answer));
        int expectedSize = service.questionsJava.size();
        //check
        assertEquals(expectedSize, actualSize);
        assertEquals(removed.getQuestion(), question);
        assertEquals(removed.getAnswer(), answer);
    }

    @Test
    @DisplayName("Получает все вопросы/ответы")
    public void getAll (){
        //given
        Collection <Question> actual = service.questionsJava;
        // when
        Collection<Question> expected = service.questionsJava;
        //check
        assertEquals(expected, actual);

    }





}