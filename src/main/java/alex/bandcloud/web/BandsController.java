package alex.bandcloud.web;

import alex.bandcloud.model.Band;
import alex.bandcloud.repos.BandRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        List<Band> list = new ArrayList<>();
        Band.Genre[] genres = Band.Genre.values();

        for(Band.Genre genre : genres) {
            for(Band band : bandRepo.findDistinctByGenre(genre)) {
                list.add(band);
            }
        }
        model.addAttribute("bands", list);

    }

    @GetMapping
    public String showCreatedBands() {
        return "bands";
    }
}
