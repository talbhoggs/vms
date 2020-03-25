package ph.outlook.amperca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ph.outlook.amperca.model.Votes;

public interface VotesRepository extends JpaRepository<Votes, Integer> {

}
