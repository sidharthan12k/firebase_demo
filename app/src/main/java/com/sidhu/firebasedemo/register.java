package com.sidhu.firebasedemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class register extends AppCompatActivity {
private Button btSubmit;
private EditText etusr,etpass;
private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btSubmit = findViewById(R.id.submit);
        etusr = findViewById(R.id.usrName);
        etpass = findViewById(R.id.usrPass);
        auth = FirebaseAuth.getInstance();
        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    String usrname = etusr.getText().toString();
                    String pass = etpass.getText().toString();
            }
        });
    }
    public void createUsr(String usr,String pass){
        auth.createUserWithEmailAndPassword(usr,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isComplete()){
                    Toast.makeText(getApplicationContext(),"Registerd",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}