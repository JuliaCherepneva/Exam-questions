package pro.sky.ExamQuestions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AmountOfQuestionsExceededException extends RuntimeException {
    public AmountOfQuestionsExceededException() {
    }

    public AmountOfQuestionsExceededException(String message) {
        super("Превышено или недостаточное количество доступных вопросов");
    }

    public AmountOfQuestionsExceededException(String message, Throwable cause) {
        super(message, cause);
    }

    public AmountOfQuestionsExceededException(Throwable cause) {
        super(cause);
    }

    public AmountOfQuestionsExceededException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
