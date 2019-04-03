package xgu.myproject.easybill.rest.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xgu.myproject.easybill.rest.user.model.Session;
import xgu.myproject.easybill.rest.user.repository.SessionRepository;
import xgu.myproject.easybill.rest.util.StringUtil;

import java.util.Optional;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    public Session createSession(long userId) {
        Session session = new Session(userId, StringUtil.generateUUID());
        return sessionRepository.save(session);
    }

    public Optional<String> checkToken(String token) {
        return this.sessionRepository.checkToken(token);
    }

    public void deleteSession(String token){
        sessionRepository.deleteBySessionIdToken(token);
    }
}
