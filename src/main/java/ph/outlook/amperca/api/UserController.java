package ph.outlook.amperca.api;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ph.outlook.amperca.model.User;
import ph.outlook.amperca.repository.UserRepository;

@RestController
@RequestMapping(value = "/user", produces = APPLICATION_JSON_VALUE)
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(method = POST)
	public ResponseEntity<User> create(@RequestBody User user) {
		
		userRepository.save(user);
		
		return ResponseEntity.ok(user);
	}
	
	@RequestMapping(method = GET)
	public @ResponseBody Iterable<User> getAllUsers() {
		return userRepository.findAll();
	}
	   
}
