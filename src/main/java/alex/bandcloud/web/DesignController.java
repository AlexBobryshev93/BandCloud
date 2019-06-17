package alex.bandcloud.web;

import alex.bandcloud.model.Band;
import alex.bandcloud.repos.BandRepo;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/design")
@Data
@RequiredArgsConstructor
public class DesignController {
    private final BandRepo bandRepo;

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
        if(bandRepo.findFirstByName(design.getName()) != null) {
            model.addAttribute("msg","ERROR: A band with such name already exists");
            return "design";
        }

        System.out.println(bandRepo.save(design));
        return "result";
    }
}