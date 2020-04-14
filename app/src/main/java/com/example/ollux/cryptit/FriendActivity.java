package com.example.ollux.cryptit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class FriendActivity extends AppCompatActivity {
    Globals globals = (Globals)getApplication();
    USER currUser = globals.currUser;
    RSA myRSA = globals.myRSA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);
    }
}
