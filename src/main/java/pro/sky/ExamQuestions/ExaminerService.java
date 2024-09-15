package pro.sky.ExamQuestions;

import java.util.Collection;

public interface ExaminerService {
    Collection <Question> getQuestions(int amount);
}
