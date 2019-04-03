package xgu.myproject.easybill.rest.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import xgu.myproject.easybill.rest.user.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User getByEmailAndAndPassword(String email, String password);
    boolean existsByEmail(String email);
}
