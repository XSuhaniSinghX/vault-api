package com.vault.vault.service;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vault.vault.model.secret;
import com.vault.vault.model.user;
import com.vault.vault.response.apiResponse;
import com.vault.vault.util.FileStorageUtil;
import com.vault.vault.service.EncryptionService;

//the 8th class (i forgot the spelling of 8th) 
@Service //this tells the diddler that we mean actual business here 

public class vaultService {
    @Autowired
    EncryptionService encrypt;
    String userbase="/app/data/users/";
    String secretbase="app/data/secrets/";
    private user getUserByToken(String token) throws Exception{//jus looking through the file to check if it exixts
        for (File f: new File(userbase).listFiles()){
            user u = FileStorageUtil.load(f.getPath(), user.class);
            if (u.token!= null&&u.token.equals(token))
            return u;
        }

        throw new Exception("Invalid token");
    }
    public apiResponse storeS(String token, String id, String secretvalue) {
    try {
        user use = getUserByToken(token);
        String path = secretbase + use.username + "/" + id + ".json";

        // If secret already exists
        if (new File(path).exists()) {
            return new apiResponse(false, "Secret already exists: " + id, null);
        }

        // Create the secret object
        secret s = new secret();
        s.id = id;
        s.secretvalue = encrypt.encrypt(secretvalue); // encrypt before saving
        s.createdAt = LocalDateTime.now();

        // Ensure folder exists
        new File(secretbase + use.username).mkdirs();

        // Save the secret
        FileStorageUtil.save(path, s);

        return new apiResponse(true, "Secret stored: " + id+"", null);

    } catch (Exception e) {
        return new apiResponse(false, e.getMessage(), null);
    }
}

    public apiResponse retriveList(String token){
        try{
            user use = getUserByToken(token);
            File userDir = new File(secretbase + use.username);
            List<String> ids=Arrays.stream(Objects.requireNonNull(userDir.listFiles())).map(f->f.getName().replace(".json","")).toList();
            return new apiResponse(true, "list of secrets", ids);
        }catch(Exception e){
            return new apiResponse(false, e.getMessage(), null);
        }
    }
    public apiResponse retrive(String token, String id){
        try{
            user use = getUserByToken(token);
          secret s=FileStorageUtil.load(secretbase+ use.username + "/" + id + ".json", secret.class);
          s.secretvalue=encrypt.decrypt(s.secretvalue);
          return new apiResponse(true, "retrieved secret", s);}
          catch (Exception e){
            return new apiResponse(false, e.getMessage(), null);
            
        }
    }
    public apiResponse delete(String token, String id){
        try{
            user use = getUserByToken(token);
            new File(secretbase+ use.username + "/" + id + ".json").delete();
            return new apiResponse(true, "Secret deleted"+id+"", null);
        }catch (Exception e){
            return new apiResponse(false, e.getMessage(), null);
        }
        
    }

}
