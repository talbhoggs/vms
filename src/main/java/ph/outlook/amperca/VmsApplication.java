package ph.outlook.amperca;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import ph.outlook.amperca.model.Election;
import ph.outlook.amperca.model.PartyList;
import ph.outlook.amperca.model.Position;
import ph.outlook.amperca.model.User;
import ph.outlook.amperca.model.UserRole;
import ph.outlook.amperca.repository.ElectionRepository;
import ph.outlook.amperca.repository.PartyListRepository;
import ph.outlook.amperca.repository.PositionRepository;
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

	  @Autowired
	  PartyListRepository partyListRepository;

	  @Autowired
	  PositionRepository positionRepository;

	  @Autowired
	  ElectionRepository electionRepository;
	  
	  //@Autowired
	  //EntityManager entityManager;

	  @Override
	  public void run(ApplicationArguments args) {
		  
		  createVoter("Charles", "Amper");
		  createVoter("Mary Joy", "Amper");
		  createPosition();
		  createPartyList();
		  createElection();
	  }

	  @Transactional
	  private void createElection() {
		  Election presidential2016 = new Election();
				  presidential2016.setName("Presidential Election 2016");
				  presidential2016.setStatus(true);
		  electionRepository.save(presidential2016);
	  }

	  @Transactional
	  private void createPosition() {
		  Position president = new Position();
		  president.setName("President");
		  Position vicePresident = new Position();
		  vicePresident.setName("Vice President");
		  Position secretary = new Position();
		  secretary.setName("Secretary");
		  positionRepository.save(president);
		  positionRepository.save(vicePresident);
		  positionRepository.save(secretary);
	  }

	  @Transactional
	  private void createPartyList() {
		  PartyList lp = new PartyList();
		  lp.setName("Liberal Party");
		  PartyList pdp = new PartyList();
		  pdp.setName("PDP Laban");
		  partyListRepository.save(lp);
		  partyListRepository.save(pdp);
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
