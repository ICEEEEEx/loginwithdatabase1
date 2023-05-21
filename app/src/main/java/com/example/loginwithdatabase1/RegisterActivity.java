package com.example.loginwithdatabase1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText username, password, repeatpassword;
    Button register;
    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextView textView = findViewById(R.id.textView6);
        TextView textView2 = findViewById(R.id.textView7);


        username = (EditText) findViewById(R.id.editTextTextPersonName);
        password = (EditText) findViewById(R.id.editTextTextPassword);
        repeatpassword = (EditText) findViewById(R.id.editTextTextPassword2);
        register = (Button) findViewById(R.id.button3);
        DB = new DBHelper(this);


        //register button
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            String user = username.getText().toString();
            String pass = password.getText().toString();
            String repass = repeatpassword.getText().toString();

            if(user.equals("")||pass.equals("")||repass.equals("")){
                Toast.makeText(RegisterActivity.this, "fill all the fields.",
                        Toast.LENGTH_LONG).show();
            }else{
                if(pass.equals(repass)){
                    Boolean checkuser = DB.checkusername(user);
                    if(checkuser==false){
                        Boolean insert = DB.insertData(user, pass);
                        if(insert==true){
                            Toast.makeText(RegisterActivity.this, "Registration successful!", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(RegisterActivity.this, "Registration failed!", Toast.LENGTH_LONG).show();
                        }
                    }else{
                        Toast.makeText(RegisterActivity.this, "User already exists please sign sn", Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(RegisterActivity.this, "Passwords are not matching", Toast.LENGTH_LONG).show();
                }
            }

//                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
//                startActivity(intent);
            }
        });




        //back to main.
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        //not registered? Register here!
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });







    }
}