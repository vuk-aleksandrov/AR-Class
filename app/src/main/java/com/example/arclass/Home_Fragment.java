package com.example.arclass;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Collections;

public class Home_Fragment extends Fragment {

    public static RecyclerView layout;
    public static LessonAdapter lessonAdapter;
    ArrayList<Lesson> lessonList;

    public Home_Fragment()
    {


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setHasOptionsMenu(true);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        layout = view.findViewById(R.id.lessonContainer);

        lessonAdapter = new LessonAdapter(getContext(), MyLessons.lessons);

        layout.setLayoutManager(new LinearLayoutManager(getContext()));
        layout.setAdapter(lessonAdapter);

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(layout);
    }

    Lesson deletedModel = null;

    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.START | ItemTouchHelper.END, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            int fromPosition = viewHolder.getAdapterPosition();
            int toPostition = target.getAdapterPosition();

            Collections.swap(MyLessons.lessons, fromPosition, toPostition);
            layout.getAdapter().notifyItemMoved(fromPosition, toPostition);

            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            int positon = viewHolder.getAdapterPosition();
            switch (direction)
            {
                case ItemTouchHelper.LEFT:
                    deletedModel = MyLessons.lessons.get(positon);
                    MyLessons.lessons.remove(positon);
                    lessonAdapter.notifyItemRemoved(positon);
                    Snackbar.make(layout, String.valueOf(deletedModel.name) + " Lessson deleted", Snackbar.LENGTH_LONG)
                            .setAction("Undo", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    MyLessons.lessons.add(positon, deletedModel);
                                    lessonAdapter.notifyItemInserted(positon);
                                }
                            }).show();
                    break;
                case ItemTouchHelper.RIGHT:
                    deletedModel = MyLessons.lessons.get(positon);
                    MyLessons.lessons.remove(positon);
                    lessonAdapter.notifyItemRemoved(positon);
                    Snackbar.make(layout, String.valueOf(deletedModel.name) + " Lessson deleted", Snackbar.LENGTH_LONG)
                            .setAction("Undo", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    MyLessons.lessons.add(positon, deletedModel);
                                    lessonAdapter.notifyItemInserted(positon);
                                }
                            }).show();
                    break;
            }
        }
    };

}