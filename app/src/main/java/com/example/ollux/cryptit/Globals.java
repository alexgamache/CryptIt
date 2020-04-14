package com.example.ollux.cryptit;


import android.app.Application;

import java.security.KeyPair;
import java.security.PublicKey;

public class Globals extends Application {
    public static USER currUser;

    static {
        try {
            currUser = new USER();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int  numOfFriends;
    public static PublicKey[] publicKeys = new PublicKey[25];
    public static String[] friendNames = new String [25];

    public USER getUser(){
        return this.currUser;
    }
    public void setData(USER d){
        this.currUser=d;
    }
    public void setKeyPair(KeyPair d){
        this.currUser.pair=d;
    }
    public void addFriend(PublicKey friendKey, String friendName){
        publicKeys[numOfFriends]= friendKey;
        numOfFriends= numOfFriends+1;
    }
    public PublicKey getFriendKey (int friendNum){
        return publicKeys[friendNum];
    }
    public PublicKey getFriendKey (String friendName){
        for(int i = 0; i<numOfFriends;i++){
            if(friendNames[i]==friendName){
                return publicKeys[i];
            }
        }
        return null;
    }
}
