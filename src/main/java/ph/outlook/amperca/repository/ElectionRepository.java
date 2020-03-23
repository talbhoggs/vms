package ph.outlook.amperca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ph.outlook.amperca.model.Election;

public interface ElectionRepository extends JpaRepository<Election, Integer> {

}
