package xgu.myproject.easybill.rest.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xgu.myproject.easybill.rest.user.model.Session;
import xgu.myproject.easybill.rest.user.model.User;
import xgu.myproject.easybill.rest.user.repository.UserRepository;
import xgu.myproject.easybill.rest.util.StringUtil;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SessionService sessionService;

    @Transactional
    public Session register(User user) {
        user.setPassword(StringUtil.getMD5String(user.getPassword()));
        long userId = userRepository.save(user).getId();
        Session session = sessionService.createSession(userId);
        session.setUserNickName(user.getNickname());
        return session;
    }

    public boolean checkEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public Session login(User user) {
        User dbUser = userRepository.getByEmailAndAndPassword(user.getEmail(), StringUtil.getMD5String(user.getPassword()));
        if(dbUser != null){
            Session session = sessionService.createSession(dbUser.getId());
            session.setUserNickName(dbUser.getNickname());
            return session;
        } else {
            return null;
        }
    }
}
