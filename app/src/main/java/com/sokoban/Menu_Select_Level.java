package com.sokoban;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.ToggleButton;

public class Menu_Select_Level extends AppCompatActivity {

    public Game_Control myGame_Control = new Game_Control();


    int nrButtons = 5; // define the Number of Toggle Buttons - Levels
    public ToggleButton[] btnLevel = new ToggleButton[nrButtons]; // Array for the Select Level Buttons
    int i=0,f=1; // Variables for Loop
    int LvlName=1, setPos_x=1, setPos_y=1;
    int Base, dpWidth;  //Variables for Display Size

    static int[][] Level_1 = Levels.GetLvl_1(); //define Level Arrays for management
    static int[][] Level_2 = Levels.GetLvl_2();
    static int[][] Level_3 = Levels.GetLvl_3();
    static int[][] Level_4 = Levels.GetLvl_4();
    static int[][] Level_5 = Levels.GetLvl_5();

    static int[][] currentLvl;
    static int[] nrItemWall = Levels.GetNrItemWalls();// max number of the walls - the game also run, if less walls are placed, but not if more!
    static int[] nrItemBox = Levels.GetNrItemBoxes(); // important - the nr of the goals must be the same of the boxes!
    static int nrCurrentLvl=1; // needed for the next lvl Button
    static boolean GesturesActive;

    static int[][] GetCurrentLvl(){return currentLvl;}
    static int GetLvlNrWall(){return nrItemWall[nrCurrentLvl-1];}
    static int GetLvlNrBox(){return nrItemBox[nrCurrentLvl-1];}
    static int GetCurrentLvlNr(){return nrCurrentLvl;}
    static boolean GetGesturesActivation(){return GesturesActive;}

    static void SetNextLvl(int nrNextLvl){
        if(nrNextLvl==2){
            currentLvl= Level_2;
            nrCurrentLvl = 2;

        }
        if(nrNextLvl==3){
            currentLvl= Level_3;
            nrCurrentLvl = 3;
        }
        if(nrNextLvl==4){
            currentLvl= Level_4;
            nrCurrentLvl = 4;
        }
        if(nrNextLvl==5){
            currentLvl= Level_5;
            nrCurrentLvl = 5;
        }
    }

    @SuppressLint({"UseCompatLoadingForDrawables", "SetTextI18n", "DefaultLocale"})
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
            btnLevel[i].setText(String.format("%d", LvlName));
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
        btnBack.setOnClickListener(view -> {
            Intent intent = new Intent(Menu_Select_Level.this, MainActivity.class);   //Switch to Page Select Level
            startActivity(intent);
        });


        btnStart.setOnClickListener(view -> {

            if (btnLevel[0].isChecked()) { //Switch to Page Selected Level
                currentLvl= Level_1;
                nrCurrentLvl = 1;
               // GesturesActive = true;
                Intent intent = new Intent(Menu_Select_Level.this, myGame_Control.getClass());
                startActivity(intent);
            }

            if (btnLevel[1].isChecked()) { //Switch to Page Selected Level
                currentLvl= Level_2;
                nrCurrentLvl = 2;
              //  GesturesActive = false;
                Intent intent = new Intent(Menu_Select_Level.this, myGame_Control.getClass());
                startActivity(intent);
            }

            if (btnLevel[2].isChecked()) { //Switch to Page Selected Level
                currentLvl= Level_3;
                nrCurrentLvl = 3;
             //   GesturesActive = false;
                Intent intent = new Intent(Menu_Select_Level.this, myGame_Control.getClass());
                startActivity(intent);
            }

            if (btnLevel[3].isChecked()) { //Switch to Page Selected Level
                currentLvl= Level_4;
                nrCurrentLvl = 4;
             //   GesturesActive = false;
                Intent intent = new Intent(Menu_Select_Level.this, myGame_Control.getClass());
                startActivity(intent);
            }

            if (btnLevel[4].isChecked()) { //Switch to Page Selected Level
                currentLvl= Level_5;
                nrCurrentLvl = 5;
              //  GesturesActive = false;
                Intent intent = new Intent(Menu_Select_Level.this, myGame_Control.getClass());
                startActivity(intent);
            }

        });


        /*------------------------- Call Button Functions --------------------------------------*/
        btnLevel[0].setOnClickListener(view -> {

            for (i = 0; i < nrButtons; i++) {
                btnLevel[i].setChecked(false);
            }
            btnLevel[0].setChecked(true);

        });

        btnLevel[1].setOnClickListener(view -> {

            for (i = 0; i < nrButtons; i++) {
                btnLevel[i].setChecked(false);
            }
            btnLevel[1].setChecked(true);

        });

        btnLevel[2].setOnClickListener(view -> {

            for (i = 0; i < nrButtons; i++) {
                btnLevel[i].setChecked(false);
            }
            btnLevel[2].setChecked(true);

        });

        btnLevel[3].setOnClickListener(view -> {

            for (i = 0; i < nrButtons; i++) {
                btnLevel[i].setChecked(false);
            }
            btnLevel[3].setChecked(true);

        });

        btnLevel[4].setOnClickListener(view -> {

            for (i = 0; i < nrButtons; i++) {
                btnLevel[i].setChecked(false);
            }
            btnLevel[4].setChecked(true);

        });

    }
}