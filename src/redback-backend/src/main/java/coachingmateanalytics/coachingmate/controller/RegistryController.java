package coachingmateanalytics.coachingmate.controller;

import coachingmateanalytics.coachingmate.entity.UserPartner;
import coachingmateanalytics.coachingmate.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
//@CrossOrigin("http://localhost:3000")
public class RegistryController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    @ApiOperation(value = "register interface", notes = "user registration")
    public ResponseEntity<UserPartner> register(@ApiParam(required = true, type = "String")
    											@RequestParam("fullname") String fullname,
    											@ApiParam(required = true, type = "String")
                                                @RequestParam("username") String username,
                                                @ApiParam(required = true, type = "String")
                                                @RequestParam("password") String password,
                                                @ApiParam(required = true, type = "String")
    											@RequestParam("email") String email){
        UserPartner user = userService.register(fullname,username, password, email);
        if (user == null) return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        return ResponseEntity.ok(user);
    }

}
