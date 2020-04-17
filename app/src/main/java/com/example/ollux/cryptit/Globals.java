package com.example.ollux.cryptit;


import android.app.Application;

import java.security.Key;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;

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
    public static KeyPair keyPair[] = new KeyPair[25];
    public static PublicKey[] publicKeys = new PublicKey[25];
    public static PrivateKey[] privateKeys = new PrivateKey[25];
    public static ArrayList<String> friendNames = new ArrayList<>();
    public static ArrayList<KeyPair> keyPairs = new ArrayList<>();

    public USER getUser(){
        return this.currUser;
    }
    public void setData(USER d){
        this.currUser=d;
    }
    public void setKeyPair(KeyPair d){
        this.currUser.pair=d;
    }
    public static void addFriend(KeyPair friendKeyPair, String friendName){
        keyPair[numOfFriends] = friendKeyPair;
        keyPairs.add(numOfFriends, friendKeyPair);
        friendNames.add(numOfFriends, friendName);
        numOfFriends= numOfFriends+1;
    }
    public static int getIndexOf(String Name)
    {
        return friendNames.indexOf(Name);
    }
    public static KeyPair getKeys(int index){
        return keyPairs.get(index);
    }
    public PublicKey getFriendKey (int friendNum){
        return publicKeys[friendNum];
    }
    public PublicKey getFriendKey (String friendName){
        for(int i = 0; i<numOfFriends;i++){
            if(friendNames.get(i) ==friendName){
                return publicKeys[i];
            }
        }
        return null;
    }
}
