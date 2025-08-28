package com.vault.vault.model;
// ze third class
// This class represents a secret in the Vault application. Each secret has an ID, a value, and a timestamp for when it was created.(yo vscode writes better comments than me)
import java.time.LocalDateTime;

public class secret {
    public String id; // its going to be name of the secret
    public String secretvalue; // this one gon' be encrypted
    public String createdAt; // timestamp for when the secret was created
}
