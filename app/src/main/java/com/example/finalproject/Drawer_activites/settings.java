package com.example.finalproject.Drawer_activites;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;

import com.example.finalproject.MainActivity;
import com.example.finalproject.R;
import com.google.android.material.navigation.NavigationView;

public class settings extends AppCompatActivity {

    ImageButton backBut;
    TextView energyMonitor;
    TextView settings;
    TextView ppinkwh;
    TextView tpinkwh;
    TextView autoRefreshview;
    TextView autoRefresh;
    TextView dailynot;
    TextView spt;
    TextView timetext;
    TextView charttint;
    TextView sctc;
    EditText enterkwhp;
    EditText entertp;
    Switch autorefreshbut;
    DrawerLayout drawerlayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Status Bar Color
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimary));
        }
        setContentView(R.layout.activity_settings);

        backBut=findViewById(R.id.back_button);
        energyMonitor = findViewById(R.id.energy_monitor);
        settings = findViewById(R.id.settings);
        ppinkwh = findViewById(R.id.power_purchased);
        tpinkwh = findViewById(R.id.threshold_power);
        autoRefreshview = findViewById(R.id.automatic_refresh);
        autoRefresh = findViewById(R.id.textViewAutomaticRefresh);
        dailynot = findViewById(R.id.textViewDailyNotification);
        spt = findViewById(R.id.textViewSelectPreferredTime);
        timetext = findViewById(R.id.textViewTime);
        charttint = findViewById(R.id.textViewChartTintColor);
        sctc = findViewById(R.id.textViewSelectChartTint);
        enterkwhp =findViewById(R.id.edit_text_kwh);
        entertp = findViewById(R.id.edit_text_threshold);
        autorefreshbut = findViewById(R.id.refresh_switch);
        drawerlayout = findViewById(R.id.drawerLayout);


        // Initialize the Toolbar
        Toolbar tb = findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setTitle(getString(R.string.settings));
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);


        // Set an OnClickListener for the menu button
        backBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Navigation Drawer
                NavigationView navigationView = findViewById(R.id.navigationView);
                navigationView.setNavigationItemSelectedListener(
                        menuItem -> {
                            Intent intent;
                            if (menuItem.getItemId() == R.id.view_result) {
                                intent = new Intent(settings.this, MainActivity.class);
                                startActivity(intent);
                            } else if (menuItem.getItemId() == R.id.settings) {
                                intent = new Intent(settings.this, settings.class);
                                startActivity(intent);
                            } else if (menuItem.getItemId() == R.id.power_control) {
                                intent = new Intent(settings.this, power_control.class);
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