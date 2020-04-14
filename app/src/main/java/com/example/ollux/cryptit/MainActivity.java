package com.example.ollux.cryptit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button encryptbutton;
    private Button decryptbutton;
    private Button friendbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        encryptbutton = (Button) findViewById(R.id.encrypt);
        decryptbutton = (Button) findViewById(R.id.decrypt);
        friendbutton = (Button) findViewById(R.id.addFriend);

        encryptbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEncryptActivty();
            }
        });
        decryptbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDecryptActivty();
            }
        });
        friendbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFriendActivty();
            }
        });

    }

    public void openEncryptActivty() {
        Intent intent = new Intent(this, EncryptActivity.class);
        startActivity(intent);
    }

    public void openDecryptActivty() {
        Intent intent = new Intent(this, DecryptActivity.class);
        startActivity(intent);
    }

    public void openFriendActivty() {
        Intent intent = new Intent(this, FriendActivity.class);
        startActivity(intent);
    }
}
