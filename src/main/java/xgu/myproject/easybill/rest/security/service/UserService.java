package xgu.myproject.easybill.rest.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xgu.myproject.easybill.rest.security.model.User;
import xgu.myproject.easybill.rest.security.repository.UserRepository;
import xgu.myproject.easybill.rest.util.StringUtil;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SessionService sessionService;

    @Transactional
    public String register(User user) {
        user.setPassword(StringUtil.getMD5String(user.getPassword()));
        long userId = userRepository.save(user).getId();
        return sessionService.generateToken(userId);
    }

    public boolean checkEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public String login(User user) {
        if(userRepository.existsByIdAndAndPassword(user.getId(), StringUtil.getMD5String(user.getPassword()))) {
            return sessionService.generateToken(user.getId());
        } else {
            return "FAILED";
        }
    }
}
