package alex.bandcloud.web;

import alex.bandcloud.model.Band;
import alex.bandcloud.repos.BandRepo;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@Data
@RequiredArgsConstructor
public class BandsController {
    private final BandRepo bandRepo;

    @ModelAttribute
    public void addBandsToModel(Model model) {
        List<Band> list = (List<Band>) bandRepo.findAll();
        model.addAttribute("bands", list);
    }

    @RequestMapping(value = "/bands", method = RequestMethod.GET)
    public String showCreatedBands(Model model) {
        model.addAttribute("delete", new Integer(0));
        return "bands";
    }

    @RequestMapping(value = "/bands/delete/{id}", method = RequestMethod.GET)
    public String deleteBand(@PathVariable("id") Integer id) {
        bandRepo.delete(bandRepo.findById(id).get());
        System.out.println("Band (id =" + id + ") was deleted");
        return "redirect:/bands";
    }
}
