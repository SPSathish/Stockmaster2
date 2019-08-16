package com.sathish.stockmaster;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    EditText companyname,companyemail,password,confirmpassword;
    Button register,signin;
    FirebaseAuth mauth;
    ProgressDialog progressdialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        companyname =findViewById(R.id.cname);
        companyemail =findViewById(R.id.cmail);
        password=findViewById(R.id.pass);
        confirmpassword =findViewById(R.id.conpass);
        register =findViewById(R.id.register);
        signin=findViewById(R.id.signin);
        mauth = FirebaseAuth.getInstance();
        progressdialog  = new ProgressDialog(this);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String CnameEntered = companyname.getText().toString();
                final String CmailEntered = companyemail.getText().toString();
                final String passwordEntered = password.getText().toString();
                String conpasswordEntered = confirmpassword.getText().toString();


                if (TextUtils.isEmpty(CnameEntered)) {
                    Toast.makeText(Register.this, "please enter company name", Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(CmailEntered)) {
                    Toast.makeText(Register.this, "please enter Email", Toast.LENGTH_LONG).show();
                    return;
                }


                if (TextUtils.isEmpty(passwordEntered)) {
                    Toast.makeText(Register.this, "please enter Password", Toast.LENGTH_LONG).show();
                    return;
                }

                if (TextUtils.isEmpty(conpasswordEntered)) {
                    Toast.makeText(Register.this, "please enter Re-enter Password", Toast.LENGTH_LONG).show();
                    return;
                }


                progressdialog.setMessage("Registering Account");
                progressdialog.show();

                mauth.createUserWithEmailAndPassword(CmailEntered,passwordEntered).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            Toast.makeText(Register.this, "Register Success", Toast.LENGTH_SHORT).show();

                        } else

                        {
                            Toast.makeText(Register.this, "Register Failure,Please try again", Toast.LENGTH_SHORT).show();
                        }


                   progressdialog.dismiss();

                    }
                });



            }});

       signin.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent I =new Intent(getApplicationContext(),SignIn.class);
               startActivity(I);
           }
       });


        }





        }