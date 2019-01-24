package xgu.myproject.easybill.rest.security.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import xgu.myproject.easybill.rest.security.modal.Session;

@Repository
public interface SessionRepository extends CrudRepository<Session, Long> {
}
