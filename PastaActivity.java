package com.example.admin.easyeats;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class PastaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasta);

        setTitle("Pasta");

        ImageButton pastabtn1 = (ImageButton)findViewById(R.id.pastabutton1);
        ImageButton pastabtngray1 = (ImageButton)findViewById(R.id.pastabutton1gray);

        pastabtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PastaActivity.this, FishPieActivity.class));
            }
        });
        pastabtngray1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PastaActivity.this, FishPieActivity.class));
            }
        });
    }
}
