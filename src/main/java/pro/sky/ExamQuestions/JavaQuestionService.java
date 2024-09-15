package pro.sky.ExamQuestions;

import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class JavaQuestionService implements QuestionService {

    final static Random RANDOM = new Random();

    Set<Question> questionsJava = new HashSet<>(List.of(
            new Question ("Что такое Java?", " Это строго типизированный объектно-ориентированный язык программирования."),
            new Question("Кто разработал язык Java?", " Джеймс Гослинг."),
            new Question("В каком году была выпущена первая официальная версия — Java 1.0?", " В 1996 году."),
            new Question("Если Java - это кофе, то Bean - это...?", " Кофейное зерно."),
            new Question("Как изначально назывался язык Java?", " Oak («Дуб»).")));


    @Override
    public Question add(String question, String answer) {
        Question questions = new Question(question, answer);
        if (questionsJava.contains(questions)) {
            throw new IllegalArgumentException();
        }
        questionsJava.add(questions);
        return questions;
    }

    @Override
    public Question add(Question question) {
        questionsJava.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questionsJava.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questionsJava);
    }

    @Override
    public Question getRandomQuestion() {
        int questionIndex = RANDOM.nextInt(questionsJava.size());
        return new ArrayList<>(questionsJava).get(questionIndex);
    }
}
