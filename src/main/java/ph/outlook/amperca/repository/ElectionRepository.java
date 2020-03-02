package ph.outlook.amperca.repository;

import org.springframework.data.repository.CrudRepository;

import ph.outlook.amperca.model.Election;

public interface ElectionRepository extends CrudRepository<Election, Integer> {

}
