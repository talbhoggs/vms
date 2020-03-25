package ph.outlook.amperca.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ph.outlook.amperca.model.CandidateResponseModel;
import ph.outlook.amperca.model.Candidate;
import ph.outlook.amperca.model.Election;
import ph.outlook.amperca.model.ElectionResponseModel;
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

        Election election = electionRepository.findCurrentElection();
        HashMap<String, List<Candidate>> aggregatedCandidates = new HashMap<>();
        List<CandidateResponseModel> response = new ArrayList<>();
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
            CandidateResponseModel c = new CandidateResponseModel();
            c.setCandidates(candidates);
            c.setPosition(candidates.get(0).getPosition().getName());
            response.add(c);
        }

        model.addAttribute("election", getAggregatedCandidate());
        return "main";
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
