package ph.outlook.amperca;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import ph.outlook.amperca.model.User;
import ph.outlook.amperca.model.UserRole;
import ph.outlook.amperca.repository.UserRepository;
import ph.outlook.amperca.repository.UserRoleRepository;

@SpringBootApplication
public class VmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(VmsApplication.class, args);
	}
	
	@Component
	class App implements ApplicationRunner {
	  
	  @Autowired
	  UserRepository userRepository;
	  
	  @Autowired
	  UserRoleRepository userRoleRepository;
	  
	  //@Autowired
	  //EntityManager entityManager;
		
	  @Override
	  public void run(ApplicationArguments args) {
		  
		  //createVoter("Charles", "Amper");
		  //createVoter("Mary Joy", "Amper");
		  
	  }
	  
	  @Transactional
	  private void createVoter(String firstName, String lastName) {
		  User charles = new User();
		  charles.setFirstName(firstName);
		  charles.setLastName(lastName);
		  		  
		  UserRole user = new UserRole();
		  user.setRole("USER");
		  user.setUser(charles);

		  UserRole voter = new UserRole();
		  voter.setRole("VOTER");
		  voter.setUser(charles);
		  
		  Set<UserRole> userRoles = new HashSet<>();
		  userRoles.add(user);
		  userRoles.add(voter);
		  charles.setUserRoles(userRoles);
		  
		  userRepository.save(charles);
		  //entityManager.flush();
	  }
	}
}
