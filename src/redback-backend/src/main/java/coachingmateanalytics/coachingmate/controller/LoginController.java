package coachingmateanalytics.coachingmate.controller;

import coachingmateanalytics.coachingmate.entity.UserPartner;
import coachingmateanalytics.coachingmate.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Auther: Qi Li
 * @Date: 12/9/20 16:12
 * @Description:
 */
@Controller
@Api(tags = "login")
//@CrossOrigin("http://localhost:3000")
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    UserService userService;

    @PostMapping("/login")
    @ApiOperation(value = "login interface", notes = "user login")
    public ResponseEntity<UserPartner> login(@ApiParam(required = true, type = "String") String username,
                                             @ApiParam(required = true, type = "String") String password){
        UserPartner userPartner = userService.loginCheck(username, password);
        if (userPartner == null) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        return new ResponseEntity<>(userPartner, HttpStatus.OK);
//        UserPartner userPartner = new UserPartner();
//        userPartner.setUsername(username);
//        userPartner.setPassword(password);
//        logger.info("user username " + username + " login successfully");
//        return new ResponseEntity<>(userPartner, HttpStatus.OK);
    }
}
