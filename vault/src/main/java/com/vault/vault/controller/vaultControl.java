package com.vault.vault.controller;

import org.springframework.web.bind.annotation.RestController;

import com.vault.vault.response.apiResponse;
import com.vault.vault.service.vaultService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;



// sixth class (locked in)
@RestController
@RequestMapping("/vault")
// This annotation indicates that this class is a REST controller in Spring Boot.
public class vaultControl {
   
@Autowired
vaultService vaultservice;
    @PostMapping("/store")
  public apiResponse storeS(@RequestHeader("Authorization") String token, @RequestParam String id, @RequestParam String secretvalue){
    return vaultservice.storeS(token, id, secretvalue);
    // This method handles the storage of a secret value in the vault.
  }
    @PostMapping("/retrivelist")
    public apiResponse retriveList(@RequestHeader("Authorization") String token){
        return vaultservice.retriveList(token);
        // This method retrieves a list of all stored secrets in the vault.
    }
        @PostMapping("/retrive/{id}")
        public apiResponse retrive(@RequestHeader("Authorization") String token, @PathVariable String id){
        return vaultservice.retrive(token, id);
        // This method retrieves a specific secret by its ID from the vault.
        }
    @PostMapping("/delete/{id}")
    public apiResponse delete(@RequestHeader("Authorization") String token, @PathVariable String id){
        return vaultservice.delete(token, id);
        // This method deletes a specific secret by its ID from the vault.
    }
    
    
}
