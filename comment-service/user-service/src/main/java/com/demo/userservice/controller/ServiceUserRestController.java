package com.demo.userservice.controller;

import com.demo.userservice.entity.ServiceUser;
import com.demo.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ServiceUserRestController {

    @Autowired
    UserService userService;

    @PostMapping("/users")
    @ResponseBody
    public ResponseEntity<?> add(@RequestBody ServiceUser serviceUser) {
        try {
            Long id = userService.add(serviceUser);
            return new ResponseEntity<>(id, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/users")
    @ResponseBody
    public List<ServiceUser> getAllUsers() throws Exception {
        try {
            return userService.list();
        } catch (Exception e) {
            throw new Exception("Not found");
        }
    }
}
