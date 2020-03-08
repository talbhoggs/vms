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
		return "create-party";
	}
	@GetMapping("/create-election")
	public String createElection(Model model) {
		return "create-election";
	}
	
	@GetMapping("/create-user")
	public String createUser(Model model) {
		return "create-user";
	}
	
	@GetMapping("/create-candidate")
	public String createCandidate(Model model) {
		return "create-candidate";
	}
}
