package com.example.arclass;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
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

import java.util.ArrayList;

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

        lessonList = new ArrayList<Lesson>();
        lessonAdapter = new LessonAdapter(getContext(), lessonList);

        for(int i = 0; i < 10; i++)
        {
            Lesson aa = new Lesson();
            aa.name = String.valueOf(i);
            lessonList.add(aa);
        }

        layout.setLayoutManager(new LinearLayoutManager(getContext()));
        layout.setAdapter(lessonAdapter);
        //lessonAdapter.notifyDataSetChanged();

    }
}