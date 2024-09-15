package pro.sky.ExamQuestions;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class JavaQuestionController {
    private final QuestionService service;


    public JavaQuestionController(QuestionService service) {
        this.service = service;
    }
//@PostNapping нужно тут использовать
    @GetMapping(path = "/java/add")
    public Question addQuestion(@RequestParam("question") String question,
                                @RequestParam("answer") String answer) {
        return service.add(question, answer);
    }

    @GetMapping (path = "/java/remove")
    public Question removeQuestion (@RequestParam("question") String question,
                                    @RequestParam("answer") String answer) {
        return service.remove(new Question(question, answer));
    }
    @GetMapping (path = "/java")
    public Collection<Question> gerQuestions() {
        return service.getAll();
    }


}
