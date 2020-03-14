package ph.outlook.amperca.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ph.outlook.amperca.model.Position;
import ph.outlook.amperca.repository.PositionRepository;

@Controller
public class AdminController {
	
	@Autowired
	PositionRepository positionRepository;

	@GetMapping("/create-position")
	public String showPosition(Model model) {
		model.addAttribute("position", new Position());
		return "create-position";
	}
	
	@PostMapping("/create-position/save")
	public String createPosition(HttpServletRequest request,
		      					 @ModelAttribute("position") @Valid Position position, 
		      					 BindingResult result, 
		      					 Model model) {
		
		if (result.hasErrors()) {
	      return "create-position";
	    }
		
		positionRepository.save(position);

		return "redirect:/create-position?success=true";
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
	
	@GetMapping("/main")
	public String mainPage(Model model) {
		return "main";
	}
}
