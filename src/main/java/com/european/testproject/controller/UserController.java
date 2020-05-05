package com.european.testproject.controller;

import com.european.testproject.model.User;
import com.european.testproject.service.UserService;
import com.european.testproject.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("app/api/user")
public class UserController {

    @Autowired
    UserService userService;
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getUser(@PathVariable String id) {
        User user = userService.getUser(id);

        if(user != null)
            return new ResponseEntity<User>(user,  HttpStatus.OK);

        return new ResponseEntity<String>("User not found", HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody User saveUser(@RequestBody User user) {
        return userService.saveUser(user);

    }
}
