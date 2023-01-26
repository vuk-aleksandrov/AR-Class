package com.example.arclass;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Collections;

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

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(modelList);
    }

    AR_ModelData deletedModel = null;

    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.START | ItemTouchHelper.END, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            int fromPosition = viewHolder.getAdapterPosition();
            int toPostition = target.getAdapterPosition();

            Collections.swap(MyLessons.newLesson.models, fromPosition, toPostition);
            modelList.getAdapter().notifyItemMoved(fromPosition, toPostition);

            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            int positon = viewHolder.getAdapterPosition();
            switch (direction)
            {
                case ItemTouchHelper.LEFT:
                    deletedModel = MyLessons.newLesson.models.get(positon);
                    MyLessons.newLesson.models.remove(positon);
                    modelAdapter.notifyItemRemoved(positon);
                    Snackbar.make(modelList, String.valueOf(deletedModel.name) + " Model deleted", Snackbar.LENGTH_LONG)
                            .setAction("Undo", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    MyLessons.newLesson.models.add(positon, deletedModel);
                                    modelAdapter.notifyItemInserted(positon);
                                }
                            }).show();
                    break;
                case ItemTouchHelper.RIGHT:
                    deletedModel = MyLessons.newLesson.models.get(positon);
                    MyLessons.newLesson.models.remove(positon);
                    modelAdapter.notifyItemRemoved(positon);
                    Snackbar.make(modelList, String.valueOf(deletedModel.name) + " Model deleted", Snackbar.LENGTH_LONG)
                            .setAction("Undo", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    MyLessons.newLesson.models.add(positon, deletedModel);
                                    modelAdapter.notifyItemInserted(positon);
                                }
                            }).show();
                    break;
            }
        }

        /*@Override
        public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
            new RecyclerViewSwipeDecorator.Builder(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                    .addBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.red))
                    .addActionIcon(R.drawable.ic_baseline_delete_24)
                    .create()
                    .decorate();
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }*/
    };

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