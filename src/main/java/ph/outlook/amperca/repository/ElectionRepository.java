package ph.outlook.amperca.repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import ph.outlook.amperca.model.Election;

public interface ElectionRepository extends JpaRepository<Election, Integer>, ElectionRepositoryCustom {

}

interface ElectionRepositoryCustom {
    Election findCurrentElection();
}

class ElectionRepositoryCustomImpl implements ElectionRepositoryCustom {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Election findCurrentElection() {
        Query query = entityManager.createQuery("SELECT e FROM Election e WHERE e.status = true");
        return (Election) query.getSingleResult();
    }

}