package com.example.ollux.cryptit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EncryptActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encrypt);

        Button btn = (Button) findViewById(R.id.startencrypt);
        final EditText et = (EditText) findViewById(R.id.editTextEncrypt);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String encryptText = et.getText().toString();
            }
        });
    }
}
