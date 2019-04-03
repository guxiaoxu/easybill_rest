package xgu.myproject.easybill.rest.user.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import xgu.myproject.easybill.rest.user.model.Session;

import java.util.Optional;

@Repository
public interface SessionRepository extends CrudRepository<Session, Long> {

    @Query("SELECT sessionId.userId FROM Session WHERE sessionId.token = :token and expire > current_timestamp")
    Optional<String> checkToken(@Param("token") String token);

    void deleteBySessionIdToken(String token);

}
