package com.example.ollux.cryptit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.security.PublicKey;

public class DecryptActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decrypt);
        Button btn = (Button) findViewById(R.id.startencrypt);
        final EditText et = (EditText) findViewById(R.id.editTextEncrypt);
    }
}
