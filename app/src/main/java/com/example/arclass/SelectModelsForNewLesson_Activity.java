package com.example.arclass;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SelectModelsForNewLesson_Activity extends AppCompatActivity implements ModelPlace_BottomSheetDialog.BottomSheetListener {

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_models_for_new_lesson);

        ImageButton goBackButton=findViewById(R.id.go_back_button);
        goBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SelectModelsForNewLesson_Activity.this, DefineNewLessonDescription_Activity.class));
            }
        });

        FloatingActionButton addNewModel_Button=findViewById(R.id.add_new_model_button);
        addNewModel_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ModelPlace_BottomSheetDialog bottomSheetDialog=new ModelPlace_BottomSheetDialog();
                bottomSheetDialog.show(getSupportFragmentManager(), "model_place_bottom_sheet_dialog");
            }
        });
    }

    @Override
    public void onGoToStorageClicked() {
        Toast.makeText(getApplicationContext(), "clicked", Toast.LENGTH_SHORT).show();
        intent=new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");
        startActivityForResult(intent, 1);

        // Open AR Model and configure model info

    }

    @Override
    public void onGoToDatabaseClicked() {

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode== Activity.RESULT_OK) {
            //if(data==null) return;
            Uri fileUri=data.getData();
            Toast.makeText(getApplicationContext(), fileUri.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}