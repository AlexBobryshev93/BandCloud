package alex.bandcloud;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResultController {
    @GetMapping("/result")
    public String home() {
        return "result";
    }
}