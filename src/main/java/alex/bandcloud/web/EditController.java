package alex.bandcloud.web;

import alex.bandcloud.model.Band;
import alex.bandcloud.repos.BandRepo;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/bands/edit/{id}")
@Data
@RequiredArgsConstructor
public class EditController {
    private final BandRepo bandRepo;

    @ModelAttribute
    public void addDataToModel(Model model) {
        List<Band.Genre> genres = Arrays.asList(Band.Genre.values());
        model.addAttribute("genres", genres);
    }

    @GetMapping
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("design", bandRepo.findById(id).get());
        return "edit";
    }

    @PostMapping
    public String editBand(@ModelAttribute("design") Band design, Model model) {
        if((design.getName() != null) || (design.getName() != design.getName())) {
            model.addAttribute("msg","ERROR: A band with such name already exists");
            return "edit";
        }

        System.out.println(bandRepo.save(design));
        return "result";
    }
}
