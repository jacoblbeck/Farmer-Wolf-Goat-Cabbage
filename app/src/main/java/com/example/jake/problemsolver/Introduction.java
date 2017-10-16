package com.example.jake.problemsolver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class Introduction extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);
    }

        public void begin(View view){
        Intent intent = new Intent(this, FWGC.class);
        startActivity(intent);
    }
    }

