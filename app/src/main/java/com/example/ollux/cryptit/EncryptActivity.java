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

import java.security.KeyPair;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;

public class EncryptActivity extends AppCompatActivity {
    //We need to know how to get key from array.
    String cipherText;
    Globals globals = (Globals)getApplication();
    PublicKey publicKeys[] = Globals.publicKeys;
    //USER currUser = globals.currUser;
    ArrayList<String> friendNames = globals.friendNames;
    //PublicKey publicKey = currUser.pair.getPublic();//This needs to be pulled from array.`

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encrypt);

        Button btn = (Button) findViewById(R.id.startencrypt);
        final EditText et = (EditText) findViewById(R.id.editTextEncrypt);
        final Spinner spinner = (Spinner) findViewById(R.id.friendArray);

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>
                (this, R.layout.spinner_item,
                        friendNames); //selected item will look like a spinner set from XML
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerArrayAdapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                String encryptText = et.getText().toString();

                String text = spinner.getSelectedItem().toString();

                KeyPair tempKeys = globals.keyPairs.get(globals.friendNames.indexOf(text));

                try {
                    cipherText = RSA.encrypt(encryptText, tempKeys.getPublic());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                et.setText(cipherText);
            }

        });
        et.setText(cipherText); // should set text field with the encrypted text.
    }
}
