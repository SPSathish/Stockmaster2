package com.sathish.stockmaster;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class SignIn extends AppCompatActivity {
 EditText Email,password;
  Button signin,register;
   FirebaseAuth mauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);


        Email =findViewById(R.id.email);
        password =findViewById(R.id.password);
        signin = (Button) findViewById(R.id.signin);
        register=findViewById(R.id.register);
         mauth = FirebaseAuth.getInstance();




        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String EmailEntered =Email.getText().toString().trim();
                String PasswordEntered =password.getText().toString().trim();


                mauth.signInWithEmailAndPassword(EmailEntered,PasswordEntered).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {

                            Toast.makeText(SignIn.this,"Login is Successful",Toast.LENGTH_LONG).show();
                            Intent i= new Intent(getApplicationContext(),HomePage.class);
                            startActivity(i);

                        }

                        else
                        {
                            Toast.makeText(SignIn.this,"Login Failure ",Toast.LENGTH_LONG).show();
                        }
                    }
                });


            }
        });






        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent i= new Intent(getApplicationContext(),Register.class);
                startActivity(i);
            }
        });

    }
}
