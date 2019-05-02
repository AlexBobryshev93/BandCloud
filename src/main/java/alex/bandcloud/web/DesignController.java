package alex.bandcloud.web;

import alex.bandcloud.model.Band;
import alex.bandcloud.repos.BandRepo;
import org.springframework.beans.factory.annotation.Autowired;
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
public class DesignController {

    private BandRepo bandRepo;

    @Autowired
    public DesignController(BandRepo bandRepo) {
        this.bandRepo = bandRepo;
    }

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
        Band saved = bandRepo.save(design);
        System.out.println(saved);
        return "result";
    }
}