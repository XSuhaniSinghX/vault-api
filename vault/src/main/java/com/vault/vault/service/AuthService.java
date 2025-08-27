package com.vault.vault.service;

//guess who's back after two months of procrastination? it's me.
//let's put the fries in the bag.
// the seventh class
// This class handles the authentication service for the Vault application. 
// It includes methods for user registration and login.
// It uses a file-based storage system to save user data and employs password encryption for security.

import java.io.File;
import java.util.UUID;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.vault.vault.model.user;
import com.vault.vault.response.apiResponse;
import com.vault.vault.util.FileStorageUtil;

@Service
public class AuthService {

    // ✅ fixed path (added slash at end, removed leading "/")
    String userbase = "app/data/users/";

    PasswordEncoder encoder = new BCryptPasswordEncoder();

    public apiResponse register(String username, String password){
        // ✅ Ensure the users folder exists before saving
        File userDir = new File(userbase);
        if (!userDir.exists()) {
            userDir.mkdirs();
        }

        File userfile=new File(userbase + username + ".json");
        if(userfile.exists()){
            return new apiResponse(false ,"User already exists", null);
        }

        user use= new user();
        use.username = username;
        use.password = encoder.encode(password);
        use.token = UUID.randomUUID().toString();

        FileStorageUtil.save(userbase + username + ".json", use);

        return new apiResponse (true, "User registered successfully", use.token);
        // This method handles the registration of a new user.
        // It checks if the user already exists, and if not, it creates a new user  
    }

    public apiResponse login(String username, String password){ 
        // this ones gon be for login
        try{
            user use= FileStorageUtil.load(userbase + username + ".json", user.class);

            if(! encoder.matches(password, use.password)) {
                // if name or password doesnt match, lock the sneaky mf out
                return new apiResponse(false, "invalid credentials", null);
            }

            use.token= UUID.randomUUID().toString();
            FileStorageUtil.save(userbase + username + ".json",use);

            return new apiResponse(true, "Login successful", use.token);
        }
        catch(Exception e){
            return new apiResponse(false, "Login failed ", null);
        }
    }
}
//too much work man, think i am gonna take a nap now
