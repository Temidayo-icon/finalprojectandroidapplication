package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.finalproject.Drawer_activites.power_control;
import com.example.finalproject.Drawer_activites.settings;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerlayout;
    Button instantaneousButton;
    Button cumulativeButton;
    ImageButton menuButton;
    ImageButton refreshButton;
    TextView energymonitor;
    TextView availkwh;
    TextView kwhvalue;
    TextView cpc;
    TextView put;
    TextView tc;
    TextView tpc;
    View graphView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Status Bar Color
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimary));
        }
        setContentView(R.layout.activity_main);



        drawerlayout = findViewById(R.id.drawerLayout);
        menuButton = findViewById(R.id.menu_button);
        refreshButton =findViewById(R.id.refresh_button);
        energymonitor =findViewById(R.id.energy_monitor_title);
        availkwh =findViewById(R.id.available_kilowatt_textview);
        kwhvalue =findViewById(R.id.kwh_value_textview);
        cpc =findViewById(R.id.current_power_consumption_textview);
        put =findViewById(R.id.power_used_today_textview);
        tc =findViewById(R.id.total_consumption_textview);
        tpc =findViewById(R.id.total_power_consumption_textview);
        graphView =findViewById(R.id.graph_view);

        // Initialize the Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        assert actionbar != null;
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setTitle(getString(R.string.view_result));
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);




        // Set an OnClickListener for the menu button
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Navigation Drawer
                NavigationView navigationView = findViewById(R.id.navigationView);
                navigationView.setNavigationItemSelectedListener(
                        menuItem -> {
                            Intent intent;
                            if (menuItem.getItemId() == R.id.view_result) {
                                intent = new Intent(MainActivity.this, MainActivity.class);
                                startActivity(intent);
                            } else if (menuItem.getItemId() == R.id.settings) {
                                intent = new Intent(MainActivity.this, settings.class);
                                startActivity(intent);
                            } else if (menuItem.getItemId() == R.id.power_control) {
                                intent = new Intent(MainActivity.this, power_control.class);
                                startActivity(intent);
                            }
                            drawerlayout.closeDrawer(GravityCompat.START);
                            return true;
                        }
                );

            }
        });



    }
}