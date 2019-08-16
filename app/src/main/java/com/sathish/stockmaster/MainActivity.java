package com.sathish.stockmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button register,signin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

  register =findViewById(R.id.reg);
  signin=findViewById(R.id.sig);



  register.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {


          Intent i =new Intent(getApplicationContext(),Register.class);
          startActivity(i);
      }
  });


  signin.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

          Intent i = new Intent(getApplicationContext(),SignIn.class);
          startActivity(i);


      }
  });



    }
}
