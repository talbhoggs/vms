package ph.outlook.amperca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ph.outlook.amperca.model.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Integer> {

}
