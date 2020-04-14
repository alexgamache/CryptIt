package com.example.ollux.cryptit;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.security.PublicKey;

public class EncryptActivity extends AppCompatActivity {
    PublicKey publicKey;
    //We need to know how to get key from array.
    String cipherText;
    Globals globals = (Globals)getApplication();
    RSA myRSA = globals.myRSA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encrypt);

        Button btn = (Button) findViewById(R.id.startencrypt);
        final EditText et = (EditText) findViewById(R.id.editTextEncrypt);


        btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                String encryptText = et.getText().toString();
                try {
                    cipherText = RSA.encrypt(encryptText, publicKey);// check back here jon
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        et.setText(cipherText); // should set text field with the encrypted text.
    }
}
