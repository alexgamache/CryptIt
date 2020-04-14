package com.example.ollux.cryptit;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;

import java.security.PublicKey;

public class EncryptActivity extends AppCompatActivity {
    //We need to know how to get key from array.
    String cipherText;
    Globals globals = (Globals)getApplication();
    PublicKey publicKeys[] = Globals.publicKeys;
    USER currUser = globals.currUser;
    String[] friendNames = globals.friendNames;

    //PublicKey publicKey = currUser.pair.getPublic();//This needs to be pulled from array.`

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encrypt);

        Button btn = (Button) findViewById(R.id.startencrypt);
        final EditText et = (EditText) findViewById(R.id.editTextEncrypt);

        Spinner spinner = new Spinner(this);
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item,
                        friendNames); //selected item will look like a spinner set from XML
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerArrayAdapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                String encryptText = et.getText().toString();

                try {
                    cipherText = RSA.encrypt(encryptText, publicKeys[0]);// check back here jon!!!!!!!!
                } catch (Exception e) {
                    e.printStackTrace();
                }
                et.setText(cipherText);
            }

        });
        et.setText(cipherText); // should set text field with the encrypted text.
    }
}
