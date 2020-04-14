package com.example.ollux.cryptit;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.security.PublicKey;

public class DecryptActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decrypt);
        Button btn = (Button) findViewById(R.id.decryptButton);
        final EditText plainText = (EditText) findViewById(R.id.plainText);
        final EditText cipherText = (EditText) findViewById(R.id.cipherText);
        btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                String encryptText = cipherText.getText().toString();
                //RSA.decrypt();
            }
        });
    }
}
