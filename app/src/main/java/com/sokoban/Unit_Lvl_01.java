package com.sokoban;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.sokoban.GameEngine.GameEngineBox;
import com.sokoban.GameEngine.GameEnginePlayer;
import com.sokoban.SetWorld.Coordinate;
import com.sokoban.SetWorld.SetButtons;
import com.sokoban.SetWorld.SetField;
import com.sokoban.PrivateLibrary.RepeatButton;

public class Unit_Lvl_01 extends AppCompatActivity implements
        View.OnTouchListener,
        GestureDetector.OnGestureListener {

    int[][] field = {   {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                        {1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 3, 1, 1},
                        {1, 0, 0, 2, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 3, 3, 1},
                        {1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 3, 1},
                        {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 1},
                        {1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 2, 1, 1, 1, 1, 1, 1},
                        {1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1},
                        {1, 0, 2, 1, 0, 0, 2, 0, 0, 0, 2, 0, 0, 1},
                        {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1},
                        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
    }; // 1 = Wall // 2 = Box_brown & green // 3 = Goals // 4 = Player

    //Constants
    int nrItemWall = 90; // max number of the walls - the game also run, if less walls are placed, but not if more!
    int nrItemBox = 5; // important - the nr of the goals must be the same of the boxes!

    RelativeLayout Layout;
    MediaPlayer myPlayer;

    int dpWidth;  //Variables for Display Size
    int Base;  //Variable for Calculation Image Size also used for Play field Map coords etc
    float posPlayer_X, posPlayer_Y; //coords of the Player
    float touch_X, touch_Y; // touch cords of the display
    GameEnginePlayer.Direction direction_Gesture; // enum for selection the direction after touching the idsplay

    Handler handler = new Handler(); // define Handler for changing color of teh box if it is moved to the goal
    ImageView player, star;
    AnimatorSet animation = new AnimatorSet();
    boolean doMovePlayer;    //Used do interrupt moving animation when red Box is detected etc
    boolean lvlFinished, CheckLvlFinish;     //Boolean to set Win Animation
    boolean GesturesActiv; // Gestures are Activated and Control Buttons are deactivated
    int i; //counter

    //Define Buttons
    Button btnUp, btnDown, btnLeft, btnRight; // controler Buttons for the movement
    Button btnNextLvl, btnRestart, btnMenu; // Buttons for settings
    ToggleButton btnSettings; // toggleButtons in the settings
    GestureDetector mGesture; // gesture detector used to move the player with touching on the screen
    TextView txtSettings; // background in the settings - textfield used to implement a text

    //Arrays for Engine algorythm coords of the Boxes, Walls, Goals
    float[] posWall_X = new float[nrItemWall];
    float[] posWall_Y = new float[nrItemWall];
    float[] posBoxBrown_X = new float[nrItemBox];
    float[] posBoxBrown_Y = new float[nrItemBox];
    float[] posBoxGreen_X = new float[nrItemBox];
    float[] posBoxGreen_Y = new float[nrItemBox];
    float[] posGoal_X = new float[nrItemBox];
    float[] posGoal_Y = new float[nrItemBox];

    //Array for Items
    public ImageView[] imgWall = new ImageView[nrItemWall];
    public ImageView[] imgBoxBrown = new ImageView[nrItemBox];
    public ImageView[] imgBoxGreen = new ImageView[nrItemBox];
    public ImageView[] imgGoal = new ImageView[nrItemBox];

    //Class defined here
    SetField mySetField = new SetField(); // this class define the positions and size of all game elements
    Coordinate myCoordinate = new Coordinate(); // set the coords oof all game elements in floar arrays
    SetButtons myButtons = new SetButtons(); // set button positions and sizes
    GameEnginePlayer myGameEnginePlayer = new GameEnginePlayer(); // game engin of the player - movement & check if a wall appears
    GameEngineBox myGameEngineBox = new GameEngineBox(); // game engine of the boxes - movement & check if the box is allowed to move

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_lvl01); // set the content to the ID of the selected lvl - global definition
        mGesture = new GestureDetector(this, this); // gesture is defined global
         myPlayer=MediaPlayer.create(this,R.raw.stopthinking);
        myPlayer.start();

        /*---------------- set the App into Fullscreen Mode -----------------------------------*/
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE); //fore the app into landscape
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); // force the game into fullscreen
        setContentView(R.layout.activity_unit_lvl01); // content is connected with the selected lvl
        Layout = findViewById(R.id.Unit_Lvl_01); // layout is connected with the selected lvl

        /*------------------------- Define Display Size & Parameters --------------------------------------------*/
        DisplayMetrics DisplaySize = getResources().getDisplayMetrics(); // set display information function
        dpWidth = DisplaySize.widthPixels;// get the size of the display
        Base = dpWidth / 20; // this variable will be used to set all sizes & positions - can be easily adjusted for different screen sizes

        /*---------------- Define & set Positions for Walls, Boxes & Goals -----------------------------------*/
        imgWall = mySetField.SetWalls(Layout, imgWall, nrItemWall, Base, field);
        imgBoxBrown = mySetField.SetBoxBrown(Layout, imgBoxBrown, Base, field);
        imgBoxGreen = mySetField.SetBoxGreen(Layout, imgBoxGreen, Base, field);
        imgGoal = mySetField.SetGoals(Layout, imgGoal, Base, field);
        player = mySetField.SetPlayer(Layout, player, Base, field);
        star = mySetField.SetStar(Layout, player, Base); // the star for winning the game

        /*----------------------------- Set Coordinate ---------------------------------------------------*/
        posWall_X = myCoordinate.GetPosWall_X(imgWall, nrItemWall);
        posWall_Y = myCoordinate.GetPosWall_Y(imgWall, nrItemWall);
        posBoxBrown_X = myCoordinate.GetPosBoxBrown_X(imgBoxBrown, posBoxBrown_X, nrItemBox);
        posBoxBrown_Y = myCoordinate.GetPosBoxBrown_Y(imgBoxBrown, posBoxBrown_Y, nrItemBox);
        posBoxGreen_X = myCoordinate.GetPosBoxGreen_X(imgBoxGreen, posBoxGreen_X, nrItemBox);
        posBoxGreen_Y = myCoordinate.GetPosBoxGreen_Y(imgBoxGreen, posBoxGreen_Y, nrItemBox);
        posGoal_X = myCoordinate.GetPosGoal_X(imgGoal, posGoal_X, nrItemBox);
        posGoal_Y = myCoordinate.GetPosGoal_Y(imgGoal, posGoal_Y, nrItemBox);
        posPlayer_X = player.getX();
        posPlayer_Y = player.getY();

        /*----------------------------- Set Control Buttons ---------------------------------------------------*/
        btnUp = myButtons.SetBtnUp(Layout, Base);
        btnDown = myButtons.SetBtnDown(Layout, Base);
        btnLeft = myButtons.SetBtnLeft(Layout, Base);
        btnRight = myButtons.SetBtnRight(Layout, Base);

        /*----------------------------- Set Menu Buttons ---------------------------------------------------*/
        txtSettings = myButtons.SetTxtSettings(Layout, Base);
        btnSettings = myButtons.SetBtnSettings(Layout, Base);
        btnMenu = myButtons.SetBtnMenu(Layout, Base);
        btnNextLvl = myButtons.SetBtnNextLvl(Layout, Base);
        btnRestart = myButtons.SetBtnRestart(Layout, Base);


        /*----------------- Call Button Functions for moving the player---------------------------*/
        btnUp.setOnTouchListener(new RepeatButton(mGesture, 100, 100, view -> GameEngine(GameEnginePlayer.Direction.UP)));
        btnDown.setOnTouchListener(new RepeatButton(mGesture, 100, 100, view -> GameEngine(GameEnginePlayer.Direction.DOWN)));
        btnLeft.setOnTouchListener(new RepeatButton(mGesture, 100, 100, view -> GameEngine(GameEnginePlayer.Direction.LEFT)));
        btnRight.setOnTouchListener(new RepeatButton(mGesture, 100, 100, view -> GameEngine(GameEnginePlayer.Direction.RIGHT)));

        /*----------------- Call Button Functions for Settings---------------------------*/
        btnSettings.setOnClickListener(view -> Settings()); // open the settings

        btnMenu.setOnClickListener(view -> {
            Intent intent = new Intent(Unit_Lvl_01.this, MainActivity.class);
            startActivity(intent);
            myPlayer.stop();
        });

        btnNextLvl.setOnClickListener(view -> {
            Intent intent = new Intent(Unit_Lvl_01.this, Unit_Lvl_02.class);
            startActivity(intent);
            myPlayer.stop();
        });

        btnRestart.setOnClickListener(view -> {
            Intent intent = new Intent(Unit_Lvl_01.this, Unit_Lvl_01.class);
            startActivity(intent);
            myPlayer.stop();
        });

    }

    /*---------- Game Engine methode --------------*/
    public void GameEngine(GameEnginePlayer.Direction direction) {
        doMovePlayer = myGameEnginePlayer.CheckMovePlayer(nrItemWall, nrItemBox, direction, posPlayer_X, posPlayer_Y, posWall_X, posWall_Y, posBoxBrown_X, posBoxBrown_Y, Base); //check if the player is allowed to move
        animation = myGameEnginePlayer.MovePlayer(doMovePlayer, direction, animation, posPlayer_X, posPlayer_Y, player, Base);// move the player if it is allowed
        posPlayer_X = myGameEnginePlayer.ReturnPosition_X(); //get the current X-position of the player
        posPlayer_Y = myGameEnginePlayer.ReturnPosition_Y(); //get the current Y-position of the player

        myGameEngineBox.AnimationMovBox(direction, nrItemBox, Base, posPlayer_X, posPlayer_Y, posBoxBrown_X, posBoxBrown_Y, imgBoxBrown); //check the animation for the Box & move it if it is allowed
        posBoxBrown_X = myGameEngineBox.ReturnPosBox_X(); // get the x-current position of the boxes
        posBoxBrown_Y = myGameEngineBox.ReturnPosBox_Y();// get the y-current position of the boxes
        checkBoxOnGoal(); // check if the box is on the goal - also contains the winning methode
        checkReleaseBoxOnGoal(); // check if a box releas the goal - change from green back to brown
    }

    /*---------- Change the color to green box --------------*/
    public void checkBoxOnGoal() {
        handler.postDelayed(() -> { //delay time to change the color after the animation
            for (int e = 0; e < nrItemBox; e++) {
                for (int i = 0; i < nrItemBox; i++) {
                    if(!animation.isRunning()) { // denie changing the color while animation is still running
                        if (posBoxBrown_X[e] == posGoal_X[i] && posBoxBrown_Y[e] == posGoal_Y[i]) { // check if all XY-position of the green & brown boxes are the same
                            imgBoxGreen[e].setVisibility(View.VISIBLE);
                            imgBoxBrown[e].setVisibility(View.INVISIBLE);
                            imgBoxGreen[e].setX(posBoxBrown_X[e]);
                            imgBoxGreen[e].setY(posBoxBrown_Y[e]);
                            posBoxGreen_X[e] = posBoxBrown_X[e];
                            posBoxGreen_Y[e] = posBoxBrown_Y[e];
                            checkLevelFinish(); // call level finished methode
                        }
                    }
                }
            }
        }, 320);// set time 500ms */
    }

    /*---------- Change the color box from green back to brown --------------*/
    public void checkReleaseBoxOnGoal() {
        for (int i = 0; i < nrItemBox; i++) {
            if (!(posBoxBrown_X[i] == posBoxGreen_X[i] && posBoxBrown_Y[i] == posBoxGreen_Y[i])) {
                imgBoxGreen[i].setVisibility(View.INVISIBLE);
                imgBoxBrown[i].setVisibility(View.VISIBLE);
            }
        }
    }

    /*---------- methode always check if all boxes stay on teh goals --------------*/
    public void checkLevelFinish(){
        CheckLvlFinish = true;
        for (i = 0; i < nrItemBox; i++) {
            if (!(posBoxBrown_X[i] == posBoxGreen_X[i] && posBoxBrown_Y[i] == posBoxGreen_Y[i])) {
                CheckLvlFinish = false;
            }
        }
        if(CheckLvlFinish){ // delete all buttons, show the star and appear two buttons
            lvlFinished = true;
            btnUp.setEnabled(false);
            btnDown.setEnabled(false);
            btnLeft.setEnabled(false);
            btnRight.setEnabled(false);
            btnSettings.setEnabled(false);
            btnMenu.setVisibility(View.VISIBLE);
            btnMenu.setEnabled(true);
            btnNextLvl.setVisibility(View.VISIBLE);
            btnNextLvl.setEnabled(true);
            star.setVisibility(View.VISIBLE);
            btnMenu.setX((float) Base * 5); // set pos x
            btnMenu.setY((float) Base * 5); // set pos y
        }
    }

    /*------------------------ Setting methodes -------------------------------------------*/
    // while opening the settings, all movement buttons & gestures are blocked
    // when pressing back the gestures OR the buttons are available, depends on the settings
    public void Settings() {
        if (btnSettings.isChecked()) { // configuration for opening the settings
            btnUp.setEnabled(false);
            btnDown.setEnabled(false);
            btnLeft.setEnabled(false);
            btnRight.setEnabled(false);

            btnMenu.setVisibility(View.VISIBLE);
            btnMenu.setEnabled(true);
            btnRestart.setVisibility(View.VISIBLE);
            btnRestart.setEnabled(true);
            txtSettings.setVisibility(View.VISIBLE);
        } else { // configuration for closing the settings
                btnUp.setEnabled(true);
                btnDown.setEnabled(true);
                btnLeft.setEnabled(true);
                btnRight.setEnabled(true);

            btnMenu.setVisibility(View.INVISIBLE);
            btnMenu.setEnabled(false);
            btnRestart.setVisibility(View.INVISIBLE);
            btnRestart.setEnabled(false);
            txtSettings.setVisibility(View.INVISIBLE);
        }
    }



    /*---------------- not used but must be configured for gestures function --------------------*/

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }

}