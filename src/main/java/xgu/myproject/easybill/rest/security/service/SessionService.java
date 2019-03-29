package xgu.myproject.easybill.rest.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xgu.myproject.easybill.rest.security.model.Session;
import xgu.myproject.easybill.rest.security.repository.SessionRepository;
import xgu.myproject.easybill.rest.util.StringUtil;

import java.util.Optional;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    public String generateToken(long userId) {
        Session session = new Session(userId, StringUtil.generateUUID());
        return sessionRepository.save(session).getSessionId().getToken();
    }

    public Optional<String> checkToken(String token) {
        return this.sessionRepository.checkToken(token);
    }
}
