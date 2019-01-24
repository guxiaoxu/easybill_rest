package xgu.myproject.easybill.rest.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import xgu.myproject.easybill.rest.security.modal.User;
import xgu.myproject.easybill.rest.security.service.SessionService;
import xgu.myproject.easybill.rest.security.service.UserService;

@RestController
@RequestMapping("/user")
public class SecurityController {

    @Autowired
    private UserService userService;

    @Autowired
    private SessionService sessionService;

    @GetMapping(value = "checkEmail")
    public boolean checkEmail(@RequestParam(value = "email") String email) {
        System.out.println(email);
        return userService.checkEmail(email);
    }

    @PostMapping(value = "register")
    public String register(@RequestBody User user){
        return this.userService.register(user);
    }

    @PostMapping(value = "login")
    public String login(@RequestBody User user) {
        return this.userService.login(user);
    }

    @PostMapping(value = "logout")
    public void logout(@RequestHeader HttpHeaders headers){

    }

}
