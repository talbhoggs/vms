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
	
	
}
