package ch.bbw.lt.cluedo.view;

import ch.bbw.lt.cluedo.model.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CluedoController {
    @Autowired
    DataService service;

    @GetMapping("/")
    public String start(Model model) {
        model.addAttribute("persons", service.getPersons());
        model.addAttribute("rooms", service.getRooms());
        model.addAttribute("weapons", service.getWeapons());
        return "index";
    }
}
