package com.example.arclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class CreateNewLesson_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_lesson);

        // TODO:
        // Dugmici nemaju animaciju kada se pritisnu!!!

        ImageButton previewButton=findViewById(R.id.preview_buttom);
        previewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "preview button pressed", Toast.LENGTH_LONG).show();
            }
        });

        ImageButton confirmButton=findViewById(R.id.confirm_buttom);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "confirm button pressed", Toast.LENGTH_LONG).show();
            }
        });

        ImageButton cancelButton=findViewById(R.id.cancel_button);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "cancel button pressed", Toast.LENGTH_LONG).show();

                startActivity(new Intent(CreateNewLesson_Activity.this, MainActivity.class));
            }
        });
    }
}