package com.vault.vault.service;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Service;

// 9th class
// This class is responsible for handling encryption and decryption of secrets in the Vault application.
@Service
public class EncryptionService {
    String key = "theogvaultprojec"; // 16-char AES key
    //making really easy....because i dont wanna go through the hassle of making a key generator(will do it later)
    //downsides of raw dogging the code.
    public String encrypt(String input) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key.getBytes(), "AES"));
        return Base64.getEncoder().encodeToString(cipher.doFinal(input.getBytes()));
    }
     public String decrypt(String enc) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.getBytes(), "AES"));
        return new String(cipher.doFinal(Base64.getDecoder().decode(enc)));
    }

}
