package xgu.myproject.easybill.rest.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xgu.myproject.easybill.rest.user.filter.SessionTokenAuthFilter;
import xgu.myproject.easybill.rest.user.model.User;
import xgu.myproject.easybill.rest.user.model.Session;
import xgu.myproject.easybill.rest.user.service.SessionService;
import xgu.myproject.easybill.rest.user.service.UserService;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SessionService sessionService;

    @GetMapping(value = "checkEmail")
    public Map checkEmail(@RequestParam(value = "email") String email) {
        System.out.println(email);
        return Collections.singletonMap("result", userService.checkEmail(email));
    }

    @PostMapping
    public Session register(@RequestBody User user){
        return this.userService.register(user);
    }

    @PostMapping(value = "session") //login
    public ResponseEntity<?> login(@RequestBody User user) {
        Session session = this.userService.login(user);
        if(session != null){
            return ResponseEntity.ok(session);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap("message", "Invalid email or password!"));
        }
    }

    @DeleteMapping(value = "session") //logout
    public void logout(@RequestHeader HttpHeaders headers){
        sessionService.deleteSession(headers.get(SessionTokenAuthFilter.TOKEN_HEADER_KEY).get(0));
    }

}
