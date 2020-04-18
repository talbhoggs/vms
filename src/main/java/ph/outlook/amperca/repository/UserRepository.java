package ph.outlook.amperca.repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import ph.outlook.amperca.model.Election;
import ph.outlook.amperca.model.User;

public interface UserRepository extends JpaRepository<User, Integer>, UserRepositoryCustom {

}

interface UserRepositoryCustom {
    User findByEmail(String email);
}

class UserRepositoryCustomImpl implements UserRepositoryCustom {

    @Autowired
    private EntityManager entityManager;

    @Override
    public User findByEmail(String email) {
        Query query = entityManager.createQuery("SELECT e FROM User e WHERE e.email = :email");
        query.setParameter("email", email);
        return (User) query.getSingleResult();
    }

}