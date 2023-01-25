package com.example.arclass;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Home_Fragment homeFragment = new Home_Fragment();
    SearchFragment searchFragment = new SearchFragment();
    Add_Fragment addFragment = new Add_Fragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView1);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView1, homeFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView1, homeFragment).commit();
                        return true;
                    case R.id.search:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView1, searchFragment).commit();
                        return true;
                    case R.id.add:
                        //getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView1, addFragment).addToBackStack("name").commit();

                        // Open new activity for configuring lesson data(models and it's info)
                        startActivity(new Intent(MainActivity.this, Lesson_Info_Activity.class));
                        return true;
                }
                return false;
            }
        });
    }
}