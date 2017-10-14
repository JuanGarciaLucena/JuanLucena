package com.emebesoft.juanlucena.ui.main.activities;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.emebesoft.juanlucena.R;
import com.emebesoft.juanlucena.Utils.UIUtils;
import com.emebesoft.juanlucena.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);
        initializeUI();
        setListeners();
    }

    public void initializeUI(){
        UIUtils.disableShiftMode(activityMainBinding.bottomNavigation);
    }

    public void setListeners(){

        activityMainBinding.bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                switch (item.getItemId()){

                    case R.id.action_intro:
                        Toast.makeText(MainActivity.this, "INTRO", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_experience:
                        Toast.makeText(MainActivity.this, "EXPERIENCE", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_projects:
                        Toast.makeText(MainActivity.this, "PROJECTS", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_examples:
                        Toast.makeText(MainActivity.this, "EXAMPLES", Toast.LENGTH_SHORT).show();
                        break;
                }

                return true;
            }
        });
    }
}