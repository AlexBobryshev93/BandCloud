package alex.bandcloud;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/design")
public class DesignController {
    @ModelAttribute
    public void addDataToModel(Model model) {
        List<Band.Genre> genres = Arrays.asList(Band.Genre.values());
        model.addAttribute("genres", genres);
    }

    @GetMapping
    public String showDesignForm(Model model) {
        model.addAttribute("design", new Band());
        return "design";
    }

    @PostMapping
    public String processDesign(@ModelAttribute("design") Band design, Model model) {
        //System.out.println(design);
        return "redirect:/result";
    }
}