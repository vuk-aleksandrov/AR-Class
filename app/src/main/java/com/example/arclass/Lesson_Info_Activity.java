package com.example.arclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class Lesson_Info_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_info);

        MyLessons.newLesson=new Lesson();

        ImageButton goBackButton=findViewById(R.id.go_back_button);
        goBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyLessons.newLesson=null;
                finish();
            }
        });

        ImageButton continueButton=findViewById(R.id.continue_button);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText lessonName=findViewById(R.id.lesson_name_edit_text);
                EditText lessonInfo=findViewById(R.id.lesson_info_edit_text);

                MyLessons.newLesson.name=lessonName.getText().toString();
                MyLessons.newLesson.info=lessonInfo.getText().toString();

                startActivity(new Intent(Lesson_Info_Activity.this, SelectModels_Activity.class));
            }
        });
    }
}