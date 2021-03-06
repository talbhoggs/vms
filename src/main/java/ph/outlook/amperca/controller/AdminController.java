package ph.outlook.amperca.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ph.outlook.amperca.model.Candidate;
import ph.outlook.amperca.model.CandidateRequestModel;
import ph.outlook.amperca.model.Election;
import ph.outlook.amperca.model.PartyList;
import ph.outlook.amperca.model.Position;
import ph.outlook.amperca.model.User;
import ph.outlook.amperca.model.UserRole;
import ph.outlook.amperca.repository.CandidateRepository;
import ph.outlook.amperca.repository.ElectionRepository;
import ph.outlook.amperca.repository.PartyListRepository;
import ph.outlook.amperca.repository.PositionRepository;
import ph.outlook.amperca.repository.UserRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    PositionRepository positionRepository;

    @Autowired
    PartyListRepository partyRepository;

    @Autowired
    ElectionRepository electionRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CandidateRepository candidateRepository;

    @GetMapping("/create-position")
    public String showPosition(Model model) {
        model.addAttribute("position", new Position());
        return "create-position";
    }

    @PostMapping("/create-position/save")
    public String createPosition(HttpServletRequest request, @ModelAttribute("position") @Valid Position position,
            BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "create-position";
        }

        positionRepository.save(position);

        return "redirect:/create-position?success=true";
    }

    @GetMapping("/create-party")
    public String showParty(Model model) {
        model.addAttribute("party", new PartyList());
        return "create-party";
    }

    @PostMapping("/create-party/save")
    public String createParty(HttpServletRequest request, @ModelAttribute("party") @Valid PartyList party,
            BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "create-party";
        }

        partyRepository.save(party);

        return "redirect:/create-party?success=true";
    }

    @GetMapping("/create-election")
    public String createElection(Model model) {
        model.addAttribute("election", new Election());
        return "create-election";
    }

    @PostMapping("/create-election/save")
    public String createElection(HttpServletRequest request, @ModelAttribute("election") @Valid Election election,
            BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "create-election";
        }

        election.setStatus(true);
        electionRepository.save(election);

        return "redirect:/create-election?success=true";
    }

    @GetMapping("/create-user")
    public String showUser(Model model) {
        model.addAttribute("user", new User());
        return "create-user";
    }

    @PostMapping("/create-user/save")
    @Transactional
    public String createUser(HttpServletRequest request, @ModelAttribute("user") @Valid User user, BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            return "create-user";
        }

        UserRole voter = new UserRole();
        voter.setRole(UserRole.ROLE.VOTER.name());
        voter.setUser(user);

        Set<UserRole> userRoles = new HashSet<>();
        userRoles.add(voter);
        user.setUserRoles(userRoles);

        userRepository.save(user);

        return "redirect:/create-user?success=true";
    }

    @GetMapping("/create-candidate")
    public String showCandidate(Model model) {
        initializeForm(model);
        return "create-candidate";
    }

    @PostMapping("/create-candidate/save")
    @Transactional
    public String createCandidate(HttpServletRequest request,
            @ModelAttribute("candidate") @Valid CandidateRequestModel candidateModel, BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            // initializeForm(model);
            model.addAttribute("partyList", partyRepository.findAll());
            model.addAttribute("positions", positionRepository.findAll());
            model.addAttribute("elections", electionRepository.findAll());
            return "create-candidate";
        }

        Candidate candidate = new Candidate();
        candidate.setPartList(partyRepository.findById(candidateModel.getPartyId()).get());
        candidate.setPosition(positionRepository.findById(candidateModel.getPositionId()).get());
        candidate.setElection(electionRepository.findById(candidateModel.getElectionId()).get());

        try {
            BeanUtils.copyProperties(candidate, candidateModel);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        candidateRepository.save(candidate);

        return "redirect:/create-candidate?success=true";
    }

    private void initializeForm(Model model) {
        model.addAttribute("candidate", new CandidateRequestModel());
        model.addAttribute("partyList", partyRepository.findAll());
        model.addAttribute("positions", positionRepository.findAll());
        model.addAttribute("elections", electionRepository.findAll());
    }

}
