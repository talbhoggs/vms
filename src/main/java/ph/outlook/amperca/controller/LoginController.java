package ph.outlook.amperca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ph.outlook.amperca.repository.ElectionRepository;

@Controller
public class LoginController {

    @Autowired
    private ElectionRepository electionRepository;

    @GetMapping("/")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/index")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/main")
    public String mainPage(Model model) {
        model.addAttribute("election", electionRepository.findCurrentElection());
        return "main";
    }

}
