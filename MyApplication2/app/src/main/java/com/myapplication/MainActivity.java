package com.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         username= (EditText) findViewById(R.id.editText_username);
         password= (EditText) findViewById(R.id.edittext_password);
        Button login=(Button) findViewById(R.id.button_login);
        Button register=(Button) findViewById(R.id.button_register);
         login.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 String user=username.getText().toString();
                 String pass=password.getText().toString();
                 Intent intent=new Intent(getApplicationContext(),LoggedInActivity.class);
                 intent.putExtra("Username",user);
                 intent.putExtra("Password",pass);
                 Toast.makeText(getApplicationContext(),"Login Successfull",Toast.LENGTH_SHORT).show();
                 startActivity(intent);
                 finish();


             }
         });


    }
}
