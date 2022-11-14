package com.sidhu.firebasedemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {
private Button btLogin;
private EditText etusr,etpass;
private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etusr = findViewById(R.id.usrName);
        etpass= findViewById(R.id.usrPass);
        btLogin = findViewById(R.id.submit);
        auth = FirebaseAuth.getInstance();
        btLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String usr = etusr.getText().toString();
                String pass = etpass.getText().toString();

            }
        });
    }

    public void loginusr(String usr,String pass) {
            auth.signInWithEmailAndPassword(usr,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isComplete()){
                        Toast.makeText(getApplicationContext(),"Registerd",Toast.LENGTH_SHORT).show();
                    }
                }
            });
    }
}