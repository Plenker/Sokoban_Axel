package com.sokoban;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sokoban.SetWorld.SetField;

public class MainActivity extends AppCompatActivity {

    int Base, dpWidth, gameTextSize;  //Variables for Display Size
    TextView txtGameName;

    //Class
    SetField mySetField = new SetField();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*---------------- set the App into Fullscreen Mode ----------------------------*/
       // setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        RelativeLayout Layout = findViewById(R.id.MainActivity);

        /*------------------------- Define Display Size & Parameters --------------------------------------------*/
        DisplayMetrics DisplaySize = getResources().getDisplayMetrics();
        dpWidth = DisplaySize.widthPixels;
        Base = dpWidth / 10;
        gameTextSize= mySetField.SetGameTextSize(dpWidth);

        /*-------------------------- Define Game Name -----------------------------------*/
        txtGameName = findViewById(R.id.txtGameName);
        txtGameName.setTextSize((float) gameTextSize);
        txtGameName.setX((float) (Base*2));
        txtGameName.setY((float) (Base*0.9));

        /*-------------------------- Define Button Select Lvl -----------------------------------*/
        Button btnSelectLevel = new Button(this);
        Layout.addView(btnSelectLevel);
        btnSelectLevel.setLayoutParams(new RelativeLayout.LayoutParams(Base*3, Base));
        btnSelectLevel.setBackgroundColor(getResources().getColor(R.color.purple_700));
        btnSelectLevel.setText("Select Lvl");
        btnSelectLevel.setTextSize(Base/8);
        btnSelectLevel.setTextColor(getResources().getColor(R.color.white));
        btnSelectLevel.setX((float) (Base*2));
        btnSelectLevel.setY((float) (Base*3));

        /*-------------------------- Define Button Menu -----------------------------------*/
        Button btnInfo = new Button(this);
        Layout.addView(btnInfo);
        btnInfo.setLayoutParams(new RelativeLayout.LayoutParams(Base*2, Base));
        btnInfo.setBackgroundColor(getResources().getColor(R.color.purple_700));
        btnInfo.setText("Info");
        btnInfo.setTextSize(Base/8);
        btnInfo.setTextColor(getResources().getColor(R.color.white));
        btnInfo.setX((float) (Base * 6));
        btnInfo.setY((float) (Base *3));

        /*---------------- Call Button Functions ----------------------------*/
        btnSelectLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Menu_Select_Level.class);   //Switch to Page Select Level
                startActivity(intent);
            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           //     Intent intent = new Intent(MainActivity.this, Info.class);          //Switch to Page Info
           //     startActivity(intent);
            }
        });





    }
}