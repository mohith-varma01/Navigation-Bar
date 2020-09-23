package com.example.navigationbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpToolbar();
        setUpNavigationDrawerIcon();
        setUpListeners();
    }

    private void setUpListeners()
    {
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.item1:
                        Toast.makeText(MainActivity.this, "You CLicked item 1", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.item2:
                        Toast.makeText(MainActivity.this, "You CLicked item 2", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        return true;
                    case R.id.item3:
                        Toast.makeText(MainActivity.this, "You CLicked item 3", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        return false;
                }

                return false;
            }
        });

        View headerView = navigationView.getHeaderView(0);
        TextView name = headerView.findViewById(R.id.CR7);
        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "You CLicked header", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setUpToolbar()
    {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void setUpNavigationDrawerIcon()
    {
        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.on_drawer_opened, R.string.on_drawer_opened);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }
}