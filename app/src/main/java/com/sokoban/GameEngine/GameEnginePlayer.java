package com.sokoban.GameEngine;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.sokoban.R;

public class GameEnginePlayer {

    private float currentPlayer_X, currentPlayer_Y; //current position of the player
    public enum Direction {UP, DOWN, LEFT, RIGHT, STAY}; // enum for movement directin
    int i,e; // counter

/*------------- check if movement is allowed -------------*/
    public boolean CheckMovePlayer(int nrWall, int nrBox,
                                   Direction direction,
                                   float player_X, float player_Y,
                                   float[] posWall_X, float[] posWall_Y,
                                   float[] posBox_X, float[] posBox_Y,
                                   int Base){
        boolean doAnimation = true;    //initialisation of the animation always at the beginning to TRUE
        boolean moveUp = (direction == Direction.UP);
        boolean moveDown = (direction == Direction.DOWN);
        boolean moveLeft = (direction == Direction.LEFT);
        boolean moveRight = (direction == Direction.RIGHT);
        boolean stay = (direction == Direction.STAY);

        for (e = 0; e < nrBox; e++) {
            for (i = 0; i < nrWall; i++) {

                /*-----------------Check if player is hitting a Red Wall without a Box-------------------*/
                if (    moveUp && player_X == posWall_X[i] && player_Y == posWall_Y[i] + Base
                        || moveDown && player_X == posWall_X[i] && player_Y == posWall_Y[i] - Base
                        || moveRight && player_Y == posWall_Y[i] && player_X == posWall_X[i] - Base
                        || moveLeft && player_Y == posWall_Y[i] && player_X == posWall_X[i] + Base)
                {
                    doAnimation = false;
                }

                /*-----------------Check if player is hitting a Red Wall with a Box-------------------*/
                if(moveUp) {    //Moving in UP direction
                    //Check Red Wall with Box - interrupt Moving Figure
                    if (posBox_Y[e] == posWall_Y[i] + Base && posBox_X[e] == posWall_X[i]
                            && player_Y == posBox_Y[e] + Base && player_X == posBox_X[e]) {
                        doAnimation = false;
                    }
                }

                if(moveDown) {    //Moving in DOWN direction
                    //Check Red Wall with Box - interrupt Moving Figure
                    if ((posBox_Y[e] == posWall_Y[i] - Base && posBox_X[e] == posWall_X[i])
                            && (player_Y == posBox_Y[e] - Base && player_X == posBox_X[e])) {
                        doAnimation = false;
                    }
                }

                if(moveRight) {    //Moving in RIGHT direction
                    //Check Red Wall with Box - interrupt Moving Figure
                    if ((posBox_X[e] == posWall_X[i] - Base && posBox_Y[e] == posWall_Y[i])
                            && (player_X == posBox_X[e] - Base && player_Y == posBox_Y[e])) {
                        doAnimation = false;
                    }
                }

                if(moveLeft) {    //Moving in LEFT direction
                    //Check Red Wall with Box - interrupt Moving Figure
                    if ((posBox_X[e] == posWall_X[i] + Base && posBox_Y[e] == posWall_Y[i])
                            && (player_X == posBox_X[e] + Base && player_Y == posBox_Y[e])) {
                        doAnimation = false;
                    }
                }
                if(stay) {    //stay
                        doAnimation = false;
                }

            }
        }

        /*---------------------- check if two boxes stick together  ------------------*/
        for (e = 0; e < nrBox; e++) { // two boxes are not allowed to move at the same Time
            for (i = e + 1; i < nrBox; i++) {

                if (moveUp) {
                    if ((posBox_Y[e] == posBox_Y[i] - Base || posBox_Y[i] == posBox_Y[e] - Base)
                            && posBox_X[e] == posBox_X[i]) {
                        if (player_Y == posBox_Y[e] + Base && player_X == posBox_X[e]
                                || player_Y == posBox_Y[i] + Base && player_X == posBox_X[i]) {
                            doAnimation = false;
                        }
                    }
                }

                if (moveDown) {
                    if ((posBox_Y[e] == posBox_Y[i] + Base || posBox_Y[i] == posBox_Y[e] + Base)
                            && posBox_X[e] == posBox_X[i]) {
                        if (player_Y == posBox_Y[e] - Base && player_X == posBox_X[e]
                                || player_Y == posBox_Y[i] - Base && player_X == posBox_X[i]) {
                            doAnimation = false;
                        }
                    }
                }

                if (moveRight) {
                    if ((posBox_X[e] == posBox_X[i] + Base || posBox_X[i] == posBox_X[e] + Base)
                            && posBox_Y[e] == posBox_Y[i]) {
                        if (player_X == posBox_X[e] - Base && player_Y == posBox_Y[e]
                                || player_X == posBox_X[i] - Base && player_Y == posBox_Y[i]) {
                            doAnimation = false;
                        }
                    }
                }

                if (moveLeft) {
                    if ((posBox_X[e] == posBox_X[i] - Base || posBox_X[i] == posBox_X[e] - Base)
                            && posBox_Y[e] == posBox_Y[i]) {
                        if (player_X == posBox_X[e] + Base && player_Y == posBox_Y[e]
                                || player_X == posBox_X[i] + Base && player_Y == posBox_Y[i]) {
                            doAnimation = false;
                        }
                    }
                }

            }
        }
        return doAnimation; // true if animation is allowed
    }

    /*---------------------- move player ---------------------------------*/
    public AnimatorSet MovePlayer(boolean move,
                                  Direction direction,
                                  @NonNull AnimatorSet animatorSet,
                                  float player_X, float player_Y,
                                  ImageView player,
                                  int Base) {

        if(!animatorSet.isRunning()) { // only move if the animation is not running
            //Select the direction
            if (direction == Direction.UP && move) {
                player_Y = player_Y - Base;
                player.setImageResource(R.drawable.xml_player_animation_up);
            }
            if (direction == Direction.DOWN && move) {
                player_Y = player_Y + Base;
                player.setImageResource(R.drawable.xml_player_animation_down);
            }
            if (direction == Direction.LEFT && move) {
                player_X = player_X - Base;
                player.setImageResource(R.drawable.xml_player_animation_left);
            }
            if (direction == Direction.RIGHT && move) {
                player_X = player_X + Base;
                player.setImageResource(R.drawable.xml_player_animation_right);
            }

            if(move) {
            ObjectAnimator animatorX = ObjectAnimator.ofFloat(player, View.TRANSLATION_X, player_X);//define Animator for moving in X direction
            ObjectAnimator animatorY = ObjectAnimator.ofFloat(player, View.TRANSLATION_Y, player_Y);//define Animator for moving in Y direction
            animatorX.setDuration(300); // set time for the animation
            animatorY.setDuration(300); // set time

            AnimationDrawable runPlayer = (AnimationDrawable) player.getDrawable();
            runPlayer.start();

            animatorSet = new AnimatorSet();
            animatorSet.playTogether(animatorX, animatorY);
            animatorSet.start();

            currentPlayer_X = player_X;
            currentPlayer_Y = player_Y;
            }
        }
        return animatorSet; // return animation of moving the player
    }

    public float ReturnPosition_X(){
        return currentPlayer_X; //return current x-position of the player
    }

    public float ReturnPosition_Y(){
        return currentPlayer_Y; //return current y-position of the player
    }

    public void InitPosition_XY(float Init_X, float Init_Y){
        currentPlayer_X = Init_X; //set current x-position of the player
        currentPlayer_Y = Init_Y; //set current x-position of the player
    }


    /*----------------calculation the movement direction after touching the display------------*/
    public Direction CalcGestureDirection (float touch_X, float touch_Y, float player_X,float player_Y, int Base){
        GameEnginePlayer.Direction direction_Gesture = Direction.STAY; // default do nothing

        /*---calculation the lengh bebtween the touch coord and player coord------*/
        // result can be negativ - this is used to select the movement direction
        float Dleft = player_X - touch_X;   // lenght between position X of player and touch coord X
        float Dright = touch_X - player_X; // lenght between touch coord X and player position X
        float Dtop = player_Y - touch_Y; // lenght between position Y of player and touch coord Y
        float Dbottom = touch_Y - player_Y; // lenght between touch coord Y and player position Y

        if (Dtop > Base && Dtop > Dbottom && Dtop > Dleft && Dtop > Dright) {
            direction_Gesture = Direction.UP; // set movement direction up
        }

        if (Dbottom > Base && Dbottom > Dleft && Dbottom > Dtop && Dbottom > Dright) {
            direction_Gesture = Direction.DOWN; // set movement direction down
        }

        if (Dleft > Base && Dleft > Dbottom && Dleft > Dtop && Dleft > Dright) {
            direction_Gesture = Direction.LEFT; // set movement direction left
        }

        if (Dright > Base && Dright > Dleft && Dright > Dtop && Dright > Dbottom) {
              direction_Gesture = Direction.RIGHT; // set movement direction right
        }

        return direction_Gesture; // return the movement direction
    }

}
