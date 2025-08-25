package com.vault.vault.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vault.vault.response.apiResponse;
import com.vault.vault.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


//the fifth class (keeping the classes serialized so i can remember the code after 3 months)
//first controller
@RestController 
//this annotation indicates that this class is a REST controller in Spring Boot.
// It will handle HTTP requests and responses for the Vault application.   
@RequestMapping("/auth")
//this annotation maps HTTP requests to the specified path ("/auth") to the methods in 
public class AuthControl {
    @Autowired
    //this annotation is used to inject the userService bean into this controller.
    // It allows the controller to access the userService methods for user authentication and management. 
    AuthService authservice;
    @PostMapping("/register")
  
    public apiResponse register(@RequestParam String username, @RequestParam String password){

        return authservice.register(username,password);//this method handles the registration of a new user.
        // It takes the username and password as request parameters and returns an apiResponse object.
    }
    @PostMapping("/login")
    public apiResponse login(@RequestParam String username, @RequestParam String password){
        return authservice.login(username,password);
        //this method handles the login of a user.
    }
}