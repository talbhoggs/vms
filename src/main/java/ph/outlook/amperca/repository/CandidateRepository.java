package ph.outlook.amperca.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import ph.outlook.amperca.model.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Integer>, CandidateRepositoryCustom {

}

interface CandidateRepositoryCustom {
    List<Candidate> findAllCandidates();
}

@Transactional
class CandidateRepositoryCustomImpl implements CandidateRepositoryCustom {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Candidate> findAllCandidates() {
        Query query = entityManager
                .createQuery("SELECT c FROM Candidate c join fetch c.election WHERE c.election.id = 2");
        return query.getResultList();
    }

}