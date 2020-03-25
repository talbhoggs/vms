package ph.outlook.amperca.api;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ph.outlook.amperca.model.CandidateResponseModel;
import ph.outlook.amperca.model.Candidate;
import ph.outlook.amperca.model.Election;
import ph.outlook.amperca.model.ElectionResponseModel;
import ph.outlook.amperca.model.User;
import ph.outlook.amperca.repository.CandidateRepository;
import ph.outlook.amperca.repository.ElectionRepository;
import ph.outlook.amperca.repository.UserRepository;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private ElectionRepository electionRepository;

    @RequestMapping(value = "/user", method = POST)
    public ResponseEntity<User> create(@RequestBody User user) {

        userRepository.save(user);

        return ResponseEntity.ok(user);
    }

    @RequestMapping(value = "/user", method = GET, produces = APPLICATION_JSON_VALUE)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "/candidates", method = GET, produces = APPLICATION_JSON_VALUE)
    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAllCandidates();
    }

    @RequestMapping(value = "/elections", method = GET, produces = APPLICATION_JSON_VALUE)
    public List<Election> getAllElections() {
        return electionRepository.findAll();
    }

    @RequestMapping(value = "/current-elections", method = GET, produces = APPLICATION_JSON_VALUE)
    public ElectionResponseModel findCurrentElection() {
        return getAggregatedCandidate();
    }

    private ElectionResponseModel getAggregatedCandidate() {
        Election election = electionRepository.findCurrentElection();
        HashMap<String, List<Candidate>> aggregatedCandidates = new HashMap<>();
        List<CandidateResponseModel> candidateResponse = new ArrayList<>();

        for (Candidate candidate : election.getCandidates()) {
            if (aggregatedCandidates.containsKey(candidate.getPosition().getName())) {
                aggregatedCandidates.get(candidate.getPosition().getName()).add(candidate);
            } else {
                List<Candidate> candidates = new ArrayList<>();
                candidates.add(candidate);
                aggregatedCandidates.put(candidate.getPosition().getName(), candidates);
            }
        }

        for (String key : aggregatedCandidates.keySet()) {
            List<Candidate> candidates = aggregatedCandidates.get(key);

            if (candidates.isEmpty())
                continue;

            CandidateResponseModel c = new CandidateResponseModel();
            c.setCandidates(candidates);
            c.setPosition(candidates.get(0).getPosition().getName());
            candidateResponse.add(c);
        }

        ElectionResponseModel results = new ElectionResponseModel();
        results.setElectionName(election.getName());
        results.setPositions(candidateResponse);

        return results;
    }
}
