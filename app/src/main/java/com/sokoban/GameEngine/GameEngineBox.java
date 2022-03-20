package com.sokoban.GameEngine;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.widget.ImageView;

public class GameEngineBox {
    private int i; // counter
    private float[] currentPosBox_X,  currentPosBox_Y; // current position of the player

    /*----------------- methode for moving the box --------------------*/
    public void AnimationMovBox(GameEnginePlayer.Direction direction,
                                int nrBox, int Base,
                                float player_X, float player_Y,
                                float[] posBox_X, float[] posBox_Y,
                                ImageView[] imgBox){
        boolean moveUp = (direction == GameEnginePlayer.Direction.UP);
        boolean moveDown = (direction == GameEnginePlayer.Direction.DOWN);
        boolean moveLeft = (direction == GameEnginePlayer.Direction.LEFT);
        boolean moveRight = (direction == GameEnginePlayer.Direction.RIGHT);

        for (i = 0; i < nrBox; i++) {

            //Check Animation for moving the Box UP
            if (moveUp && player_X == posBox_X[i] && player_Y == posBox_Y[i]) {
                posBox_Y[i] = posBox_Y[i] - Base;
                MoveBox(posBox_Y[i],false,imgBox[i]); // call animation methode of teh box
            }

            //Check & Call Animation for moving the Box DOWN
            if (moveDown && player_X == posBox_X[i] && player_Y == posBox_Y[i]) {
                posBox_Y[i] = posBox_Y[i] + Base;
                MoveBox(posBox_Y[i],false,imgBox[i]); // call animation methode of teh box
            }

            //Check & Call Animation for moving the Box RIGHT
            if (moveRight && player_X == posBox_X[i] && player_Y == posBox_Y[i]) {
                posBox_X[i] = posBox_X[i] + Base;
                MoveBox(posBox_X[i],true,imgBox[i]); // call animation methode of teh box
            }

            //Check & Call Animation for moving the Box LEFT
            if (moveLeft && player_X == posBox_X[i] && player_Y == posBox_Y[i]) {
                posBox_X[i] = posBox_X[i] - Base;
                MoveBox(posBox_X[i],true,imgBox[i]); // call animation methode of teh box
            }
        }
        currentPosBox_X = posBox_X; // set current X-position in private variable
        currentPosBox_Y = posBox_Y; // set current Y-position in private variable
    }

    public void MoveBox(float coords, boolean movingX, ImageView Box)
    {

        ObjectAnimator animator; // define the animator for moving animation
        if (movingX) {
            animator = ObjectAnimator.ofFloat(Box, View.TRANSLATION_X, coords); //moving the box in X-direction ( positiv or negativ)
        } else {
            animator = ObjectAnimator.ofFloat(Box, View.TRANSLATION_Y, coords); //moving the box in Y-direction ( positiv or negativ)
        }
        animator.setDuration(300); // set teh duration for the animation - must be the same for box & player

        /*----- general animation algorythm -------*/
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animator);
        animatorSet.start();
    }

    public float[] ReturnPosBox_X(){
        return currentPosBox_X; // give back x-position to the level where its called
    }

    public float[] ReturnPosBox_Y(){
        return currentPosBox_Y; // give back x-position to the level where its called
    }
}
