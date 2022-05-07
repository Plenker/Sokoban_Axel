package com.sokoban;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.ToggleButton;

public class Menu_Select_Level extends AppCompatActivity {

    int nrButtons = 10; // define the Number of Toggle Buttons - Levels
    public ToggleButton[] btnLevel = new ToggleButton[nrButtons]; // Array for the Select Level Buttons
    int i=0,f=1; // Variables for Loop
    int LvlName=1, setPos_x=1, setPos_y=1;
    int Base, dpWidth;  //Variables for Display Size

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_select_level);

        /*---------------- set the App into Fullscreen Mode ----------------------------*/
        // setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_menu_select_level);
        RelativeLayout Layout = findViewById(R.id.Menu_Select_Level);

        /*------------------------- Define Display Size & Parameters --------------------------------------------*/
        DisplayMetrics DisplaySize = getResources().getDisplayMetrics();
        dpWidth = DisplaySize.widthPixels;
        Base = dpWidth / 12;

        /*-------------------------- Define Level Buttons -----------------------------------*/

        for (i = 0; i < nrButtons; i++) {
            btnLevel[i] = new ToggleButton(this); //Define my Toggle Buttons
            Layout.addView(btnLevel[i]);
            btnLevel[i].setLayoutParams(new RelativeLayout.LayoutParams(Base, Base));
            btnLevel[i].setBackground(getResources().getDrawable(R.drawable.xml_selector_checked));
            btnLevel[i].setText(Integer.toString(LvlName));
            btnLevel[i].setTextOn(Integer.toString(LvlName));
            btnLevel[i].setTextOff(Integer.toString(LvlName));
            btnLevel[i].setTextSize(Base/8);
            btnLevel[i].setTextColor(getResources().getColor(R.color.black));
            btnLevel[i].setX((float) (Base*setPos_x));
            btnLevel[i].setY((float) (Base*setPos_y));

            //rise the Level Name & Positions --> x
            LvlName++;
            f++;
            setPos_x=setPos_x+2;

            //rise the Level Name & Positions --> y & set back x
            if(f==6){
                setPos_x=1;
                setPos_y=setPos_y+2;
                f=1;
            }

        }


        /*-------------------------- Define Button Start -----------------------------------*/
        Button btnStart = new Button(this);
        Layout.addView(btnStart);
        btnStart.setLayoutParams(new RelativeLayout.LayoutParams(Base*2, Base));
        btnStart.setBackgroundColor(getResources().getColor(R.color.purple_700));
        btnStart.setText("Start");
        btnStart.setTextSize(Base/8);
        btnStart.setTextColor(getResources().getColor(R.color.white));
        btnStart.setX((float) (Base*8));
        btnStart.setY((float) (Base*4.5));

        /*-------------------------- Define Button Back -----------------------------------*/
        Button btnBack = new Button(this);
        Layout.addView(btnBack);
        btnBack.setLayoutParams(new RelativeLayout.LayoutParams(Base*2, Base));
        btnBack.setBackgroundColor(getResources().getColor(R.color.purple_700));
        btnBack.setText("Back");
        btnBack.setTextSize(Base/8);
        btnBack.setTextColor(getResources().getColor(R.color.white));
        btnBack.setX((float) (Base));
        btnBack.setY((float) (Base*4.5));


        /*---------------- Call Button Function Back ----------------------------*/
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu_Select_Level.this, MainActivity.class);   //Switch to Page Select Level
                startActivity(intent);
            }
        });


        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (btnLevel[0].isChecked()) { //Switch to Page Selected Level
                    Intent intent = new Intent(Menu_Select_Level.this, Unit_Lvl_01.class);
                    startActivity(intent);
                }

                if (btnLevel[1].isChecked()) { //Switch to Page Selected Level
                    Intent intent = new Intent(Menu_Select_Level.this, Unit_Lvl_02.class);
                    startActivity(intent);
                }

                if (btnLevel[2].isChecked()) { //Switch to Page Selected Level
                    Intent intent = new Intent(Menu_Select_Level.this, Unit_Lvl_03.class);
                    startActivity(intent);
                }

                if (btnLevel[3].isChecked()) { //Switch to Page Selected Level
                    Intent intent = new Intent(Menu_Select_Level.this, Unit_Lvl_04.class);
                    startActivity(intent);
                }

                if (btnLevel[4].isChecked()) { //Switch to Page Selected Level
                    Intent intent = new Intent(Menu_Select_Level.this, Unit_Lvl_05.class);
                    startActivity(intent);
                }

                if (btnLevel[5].isChecked()) { //Switch to Page Selected Level
                    Intent intent = new Intent(Menu_Select_Level.this, Unit_Lvl_06.class);
                    startActivity(intent);
                }

                if (btnLevel[6].isChecked()) { //Switch to Page Selected Level
                    Intent intent = new Intent(Menu_Select_Level.this, Unit_Lvl_07.class);
                    startActivity(intent);
                }

                if (btnLevel[7].isChecked()) { //Switch to Page Selected Level
                    Intent intent = new Intent(Menu_Select_Level.this, Unit_Lvl_08.class);
                    startActivity(intent);
                }

                if (btnLevel[8].isChecked()) { //Switch to Page Selected Level
                    Intent intent = new Intent(Menu_Select_Level.this, Unit_Lvl_09.class);
                    startActivity(intent);
                }

                if (btnLevel[9].isChecked()) { //Switch to Page Selected Level
                    Intent intent = new Intent(Menu_Select_Level.this, Unit_Lvl_10.class);
                    startActivity(intent);
                }

            }
        });


        /*------------------------- Call Button Functions --------------------------------------*/
        btnLevel[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (i = 0; i < nrButtons; i++) {
                    btnLevel[i].setChecked(false);
                }
                btnLevel[0].setChecked(true);

            }
        });

        btnLevel[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (i = 0; i < nrButtons; i++) {
                    btnLevel[i].setChecked(false);
                }
                btnLevel[1].setChecked(true);

            }
        });

        btnLevel[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (i = 0; i < nrButtons; i++) {
                    btnLevel[i].setChecked(false);
                }
                btnLevel[2].setChecked(true);

            }
        });

        btnLevel[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (i = 0; i < nrButtons; i++) {
                    btnLevel[i].setChecked(false);
                }
                btnLevel[3].setChecked(true);

            }
        });

        btnLevel[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (i = 0; i < nrButtons; i++) {
                    btnLevel[i].setChecked(false);
                }
                btnLevel[4].setChecked(true);

            }
        });

        btnLevel[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (i = 0; i < nrButtons; i++) {
                    btnLevel[i].setChecked(false);
                }
                btnLevel[5].setChecked(true);

            }
        });

        btnLevel[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (i = 0; i < nrButtons; i++) {
                    btnLevel[i].setChecked(false);
                }
                btnLevel[6].setChecked(true);

            }
        });

        btnLevel[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (i = 0; i < nrButtons; i++) {
                    btnLevel[i].setChecked(false);
                }
                btnLevel[7].setChecked(true);

            }
        });

        btnLevel[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (i = 0; i < nrButtons; i++) {
                    btnLevel[i].setChecked(false);
                }
                btnLevel[8].setChecked(true);

            }
        });

        btnLevel[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (i = 0; i < nrButtons; i++) {
                    btnLevel[i].setChecked(false);
                }
                btnLevel[9].setChecked(true);

            }
        });

    }
}