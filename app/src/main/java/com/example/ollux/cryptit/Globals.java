package com.example.ollux.cryptit;


import android.app.Application;

import java.security.KeyPair;
import java.security.PublicKey;

public class Globals extends Application {
    public RSA myRSA= new RSA();
    public USER currUser= new USER();
    public int  numOfFriends;
    public PublicKey[] publicKeys = new PublicKey[25];
    public String[] friendNames = new String [25];

    public USER getUser(){
        return this.currUser;
    }

    public void setData(USER d){
        this.currUser=d;
    }
    public void setKeyPair(KeyPair d){
        this.currUser.pair=d;
    }
}
