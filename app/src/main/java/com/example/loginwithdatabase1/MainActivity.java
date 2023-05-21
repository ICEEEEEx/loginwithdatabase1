package com.example.loginwithdatabase1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

          //perejimas i kita langa.
          Intent activityChangeIntent = new Intent(MainActivity.this, RegisterActivity.class);
          MainActivity.this.startActivity(activityChangeIntent);

            Toast.makeText(MainActivity.this, "Loading",
                  Toast.LENGTH_LONG).show();


            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //perejimas i kita langa.
                Intent activityChangeIntent = new Intent(MainActivity.this, LoginActivity.class);
                MainActivity.this.startActivity(activityChangeIntent);

                Toast.makeText(MainActivity.this, "Loading",
                        Toast.LENGTH_LONG).show();


            }
        });




}
}