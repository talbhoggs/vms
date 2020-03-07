package ph.outlook.amperca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

	@GetMapping("/create-position")
	public String createPosition(Model model) {
		return "create-position";
	}
	@GetMapping("/create-party")
	public String createParty(Model model) {
		return "create-political-party";
	}
	@GetMapping("/create-election")
	public String createElection(Model model) {
		return "create-election";
	}
	
	
}
