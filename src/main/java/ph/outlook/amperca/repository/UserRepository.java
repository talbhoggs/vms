package ph.outlook.amperca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import ph.outlook.amperca.model.User;

public interface UserRepository extends JpaRepository<User, Integer>, UserRepositoryCustom {

}

interface UserRepositoryCustom {

}

class UserRepositoryCustomImpl implements UserRepositoryCustom {

}