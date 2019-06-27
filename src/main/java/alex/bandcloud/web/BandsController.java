package alex.bandcloud.web;

import alex.bandcloud.model.Band;
import alex.bandcloud.repos.BandRepo;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/bands")
@Data
@RequiredArgsConstructor
public class BandsController {
    private final BandRepo bandRepo;

    @ModelAttribute
    public void addBandsToModel(Model model) {
        List<Band> list = (List<Band>) bandRepo.findAll();
        model.addAttribute("bands", list);
    }

    @GetMapping
    public String showCreatedBands(Model model) {
        model.addAttribute("delete", new Integer(0));
        return "bands";
    }

    @DeleteMapping
    @ResponseStatus(code= HttpStatus.NO_CONTENT)
    public void deleteBand(@PathVariable("delete") Integer delete) {
        System.out.println("Band (id =" + delete + ") is being deleted");
        bandRepo.delete(bandRepo.findById(delete).get());
    }
}
