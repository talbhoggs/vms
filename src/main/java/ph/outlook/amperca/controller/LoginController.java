package ph.outlook.amperca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/index")
    public String index(Model model) {
        return "index";
    }
}
