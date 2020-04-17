package com.example.ollux.cryptit;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.security.KeyPair;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;

public class DecryptActivity extends AppCompatActivity {
    Globals globals = (Globals)getApplication();
    //USER currUser = globals.currUser;
    String decryptedText;
    ArrayList<String> friendNames = globals.friendNames;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decrypt);
        Button btn = (Button) findViewById(R.id.decryptButton);
        final EditText cipherText = (EditText) findViewById(R.id.cipherText);

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
                String encryptText = cipherText.getText().toString();
                String text = spinner.getSelectedItem().toString();
                KeyPair tempKeys = globals.keyPairs.get(globals.friendNames.indexOf(text));
                try {
                    decryptedText=RSA.decrypt(encryptText, tempKeys.getPrivate());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                cipherText.setText(decryptedText);
            }

        });
    }
}
