package pro.sky.ExamQuestions;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService{
    private final QuestionService service;

    public ExaminerServiceImpl(QuestionService service) {
        this.service = service;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {

        if (amount < 1 || amount > service.getAll().size()) {
            throw new AmountOfQuestionsExceededException ();
        }
        Set<Question> result = new HashSet<>();
        while (result.size() < amount) {
            result.add(service.getRandomQuestion());
        }

        return result;


    }


}
