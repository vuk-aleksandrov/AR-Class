package com.example.arclass;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeFragment extends Fragment {


    LinearLayout placeForPresentations;
    String yellow_color = "#FFDACF06";

    public HomeFragment()
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

        DisplayMetrics dm = new DisplayMetrics();
        ((Activity) getContext()).getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;

        int addButtonTestId = getResources().getIdentifier("addButton", "id", getContext().getPackageName());
        int holderId = getResources().getIdentifier("placeForPresentations", "id", getContext().getPackageName());
        ImageButton addButtonTest = view.findViewById(addButtonTestId);
        LinearLayout layout = view.findViewById(holderId);

        //fake presentation
        createFakePresentationHolder(layout, width, height);

        final int[] id = {2000};
        addButtonTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createPresentationHolder(layout, width, height, id[0]);
                addFakeObjectOnLayout(width, 4, layout);
                id[0]++;
            }
        });

        for(int i = 0; i < 1000; i++)
        {
            createPresentationHolder(layout, width, height, id[0]);
            addFakeObjectOnLayout(width, 4, layout);
            id[0]++;
        }



    }

    public void createPresentationHolder(LinearLayout presentationHolder, int width, int height, int id)
    {
        Button presentation = new Button(getContext());
        presentation.setLayoutParams(new ViewGroup.LayoutParams((int)(width*0.98), (int) (height * 0.15)));
        presentation.setBackgroundColor(Color.parseColor(yellow_color));
        presentation.setTextSize(20);
        presentation.setText(String.valueOf("prezetacija "+(id-2000)));
        presentation.setId(id);
        presentation.setGravity(Gravity.CENTER);
        final int finalId = id;
        presentation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), String.valueOf(finalId), Toast.LENGTH_SHORT).show();
            }
        });

        presentationHolder.addView(presentation, 0);
    }

    public void createFakePresentationHolder(LinearLayout presentationHolder, int width, int height)
    {
        Button presentation = new Button(getContext());
        presentation.setLayoutParams(new ViewGroup.LayoutParams((int)(width*0.98), (int) (height * 0.1)));
        presentation.setTextSize(20);
        presentation.setClickable(false);
        presentation.setBackgroundColor(Color.parseColor("#00FD0000"));
        presentationHolder.addView(presentation, 0);


    }

    public void addFakeObjectOnLayout(int width, int height, LinearLayout Holder) {
        Button line = new Button(getContext());
        line.setClickable(false);
        line.setLayoutParams(new ViewGroup.LayoutParams(width, height));
        line.setBackgroundColor(Color.parseColor("#00FD0000"));
        Holder.addView(line,1);
    }

    /*@Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.test_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.addButton:
            {
                Toast.makeText(getActivity(), "proba", Toast.LENGTH_SHORT).show();
                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }*/
}