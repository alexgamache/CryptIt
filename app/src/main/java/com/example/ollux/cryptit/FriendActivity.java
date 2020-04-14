package com.example.ollux.cryptit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.security.PublicKey;

public class FriendActivity extends AppCompatActivity {
    Globals globals = (Globals)getApplication();
    USER currUser = globals.currUser;
    RSA myRSA = globals.myRSA;
    private Button addFriend;
    private EditText username;
    private EditText publickey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);

        addFriend = (Button) findViewById(R.id.addFriendButton);
        username = (EditText) findViewById(R.id.FriendName);
        publickey = (EditText) findViewById(R.id.FriendPublicKey);


        addFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //globals.addFriend(,username.getText().toString());
                //final String stpublickey = new PublicKey((publickey.getText()));

            }
        });
    }
}
