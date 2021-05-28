package com.arish1999.mycontacts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {


    TextInputLayout name, contact, email;
    FloatingActionButton fb;
    Button sbmt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.nametext);
        contact = findViewById(R.id.contacttext);
        email = findViewById(R.id.emailtext);
        fb = findViewById(R.id.fbtn);
        sbmt = findViewById(R.id.sbmt_add);
        sbmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getEditText().getText().toString().equals(""))
                {
                    name.getEditText().setError("Enter name");
                }
                else if(contact.getEditText().getText().toString().equals(""))
                {
                    contact.getEditText().setError("Enter contact");
                }
                else if(email.getEditText().getText().toString().equals(""))
                {
                    email.getEditText().setError("Enter email");
                }
                else
                {
                    processInsert(name.getEditText().getText().toString(),contact.getEditText().getText().toString(),email.getEditText().getText().toString());
                }

            }
        });

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),fetchData.class));
            }
        });
    }

    private void processInsert(String n, String c, String e) {
        String res = new dbManager(this).addRecord(n,c,e);
        name.getEditText().setText("");
        contact.getEditText().setText("");
        email.getEditText().setText("");
        Toast.makeText(this,res,Toast.LENGTH_SHORT).show();
    }
}