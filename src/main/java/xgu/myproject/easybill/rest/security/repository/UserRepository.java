package xgu.myproject.easybill.rest.security.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import xgu.myproject.easybill.rest.security.modal.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    public boolean existsByIdAndAndPassword(long id, String password);
    public boolean existsByEmail(String email);
}
