package com.cua.assignment.controller;


import com.cua.assignment.model.User;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/data",
        produces = {"application/json","text/plain"})
@CrossOrigin(origins="*")
public class LoginValidatorController {

    @GetMapping(value = { "/validatelogin" })
    public ResponseEntity<User> validateLogin() {
        return ResponseEntity.ok(new User("Authentication successful"));
    }
}
