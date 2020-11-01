package com.bluejnr.petagram;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bluejnr.petagram.util.JavaMailAPI;
import com.google.android.material.textfield.TextInputEditText;

public class ActivityContact extends AppCompatActivity {

    TextInputEditText editTextName;
    TextInputEditText editTextEmail;
    TextInputEditText editTextMessage;
    Button buttonSendComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBarContact);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        editTextName = (TextInputEditText) findViewById(R.id.editTextName);
        editTextEmail = (TextInputEditText) findViewById(R.id.editTextEmail);
        editTextMessage = (TextInputEditText) findViewById(R.id.editTextMessage);
        buttonSendComment = (Button) findViewById(R.id.button_sendComment);

        buttonSendComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JavaMailAPI javaMailAPI = new JavaMailAPI( view.getContext(),
                        editTextEmail.getText().toString(),
                        editTextName.getText().toString(),
                        editTextMessage.getText().toString());
                javaMailAPI.execute();
            }
        });
    }


}