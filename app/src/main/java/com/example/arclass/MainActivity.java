package com.example.arclass;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment = new HomeFragment();
    SearchFragment searchFragment = new SearchFragment();
    AddFragment addFragment = new AddFragment();

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
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView1, homeFragment).addToBackStack("name").commit();
                        return true;
                    case R.id.search:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView1, searchFragment).addToBackStack("name").commit();
                        return true;
                    case R.id.add:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView1, addFragment).addToBackStack("name").commit();
                        return true;
                }
                return false;
            }
        });
    }
}