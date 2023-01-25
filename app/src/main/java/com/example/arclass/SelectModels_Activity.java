package com.example.arclass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class SelectModels_Activity extends AppCompatActivity implements ModelPlace_BottomSheetDialog.BottomSheetListener {

    Intent intent;

    public static RecyclerView modelList;
    public static SelectModelsAdapter modelAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_models);


        ArrayList<AR_ModelData> a=new ArrayList<>();

        modelAdapter=new SelectModelsAdapter(getApplicationContext(), MyLessons.newLesson.models);

        modelList = findViewById(R.id.model_card_holder);
        modelList.setLayoutManager(new LinearLayoutManager(this));
        modelList.setAdapter(modelAdapter);

        ImageButton goBackButton=findViewById(R.id.go_back_button);
        goBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });

        ImageButton finishButton=findViewById(R.id.finish_button);
        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MyLessons.newLesson.newModel=new AR_ModelData();
                MyLessons.newLesson.newModel.name="shit";
                MyLessons.newLesson.models.add(MyLessons.newLesson.newModel);

                modelAdapter.notifyDataSetChanged();
                modelList.scheduleLayoutAnimation();

                //MyLessons.addCreatedLesson();
                //finish();
            }
        });

        FloatingActionButton addNewModel_Button=findViewById(R.id.add_new_model_button);
        addNewModel_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MyLessons.newLesson.newModel=new AR_ModelData();

                ModelPlace_BottomSheetDialog bottomSheetDialog=new ModelPlace_BottomSheetDialog();
                bottomSheetDialog.show(getSupportFragmentManager(), "model_place_bottom_sheet_dialog");
            }
        });
    }

    @Override
    public void onGoToStorageClicked() {
        intent=new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*");
        startActivityForResult(intent, 1);

    }

    @Override
    public void onGoToDatabaseClicked() {

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode== Activity.RESULT_OK) {
            //if(data==null) return;
            MyLessons.newLesson.newModel.uri=data.getData().toString();
            Toast.makeText(getApplicationContext(), MyLessons.newLesson.newModel.uri, Toast.LENGTH_SHORT).show();

            // Open AR Model and configure model info
            startActivity(new Intent(SelectModels_Activity.this, AR_Model_Info_Activity.class));
        }
    }
}