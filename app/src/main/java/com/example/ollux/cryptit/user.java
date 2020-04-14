package com.example.ollux.cryptit;

import java.security.Key;
import java.security.KeyPair;

class USER {
    KeyPair pair;
    String Username;

    public USER() throws Exception {
       // pair =RSA.generateKeyPair();
    }
    public USER(KeyPair keys,String User){
        this.pair = keys;
        this.Username = User;
    }
    public USER(String User) throws Exception {
        this.Username = User;
        this.pair = generateKeys();//mistake here
    }
    public USER(KeyPair keys) {
        this.pair = keys;
    }
    public void setPair(KeyPair newPair){
        this.pair = newPair;
    }
    public KeyPair getPair(){
        return pair;
    }
    public String getUser(){
        return Username;
    }
    public void setUsername(String newUser){
        Username = newUser;
    }
    public String getUsername(){
        return Username;
    }
    public KeyPair generateKeys() throws Exception {
        this.pair = RSA.generateKeyPair();
        return pair;
    }
}
