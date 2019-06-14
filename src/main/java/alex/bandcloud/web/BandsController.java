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

import java.util.*;

@Controller
@RequestMapping("/bands")
public class BandsController {
    private BandRepo bandRepo;

    @Autowired
    public BandsController(BandRepo bandRepo) {
        this.bandRepo = bandRepo;
    }

    @ModelAttribute
    public void addBandsToModel(Model model) {
        List<Band> list = (List<Band>) bandRepo.findAll();
        model.addAttribute("bands", list);
        model.addAttribute("delete", new Band());
    }

    @GetMapping
    public String showCreatedBands() {
        return "bands";
    }

    @PostMapping
    public String deleteBand(@ModelAttribute("delete") Band delete) {
        System.out.println(delete);
        bandRepo.delete(delete);
        return "bands";
    }
}
