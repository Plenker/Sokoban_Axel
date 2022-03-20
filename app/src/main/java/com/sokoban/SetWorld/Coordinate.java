package com.sokoban.SetWorld;

import android.widget.ImageView;

import androidx.annotation.NonNull;

//set the coords of the Images into a float array for better handling
public class Coordinate {

    /*---------------- get X-Positions Walls -----------*/
    public float[] GetPosWall_X(ImageView[] wall, int nrWalls){
        float[] posWall_X = new float[nrWalls];
            for (int i = 0; i < nrWalls; i++) {
                posWall_X[i]= wall[i].getX();
            }
        return posWall_X; // return posWall_X
    }

    /*---------------- get Y-Positions Walls -----------*/
    public float[] GetPosWall_Y(ImageView[] wall, int nrWalls){
        float[] posWall_Y = new float[nrWalls];
        for (int i = 0; i < nrWalls; i++) {
            posWall_Y[i]= wall[i].getY();
        }
        return posWall_Y; // return posWall_Y
    }

    /*---------------- get X-Positions Brown Box -----------*/
    public float[] GetPosBoxBrown_X(ImageView[] boxBrown, float[] posBoxBrown_X, int nrBox){
        for (int i = 0; i < nrBox; i++) {
            posBoxBrown_X[i]= boxBrown[i].getX();
        }
        return posBoxBrown_X; // return posBoxBrown_X
    }

    /*---------------- get Y-Positions Brown Box -----------*/
    public float[] GetPosBoxBrown_Y(ImageView[] boxBrown, float[] posBoxBrown_Y, int nrBox){
        for (int i = 0; i < nrBox; i++) {
            posBoxBrown_Y[i]= boxBrown[i].getY();
        }
        return posBoxBrown_Y; // return posBoxBrown_Y
    }

    /*---------------- get X-Positions Green Box -----------*/
    public float[] GetPosBoxGreen_X(ImageView[] boxGreen, float[] posBoxGreen_X, int nrBox){
        for (int i = 0; i < nrBox; i++) {
            posBoxGreen_X[i]= boxGreen[i].getX();
        }
        return posBoxGreen_X; // return posBoxGreen_X
    }

    /*---------------- get Y-Positions Green Box -----------*/
    public float[] GetPosBoxGreen_Y(ImageView[] boxGreen, float[] posBoxGreen_Y, int nrBox){
        for (int i = 0; i < nrBox; i++) {
            posBoxGreen_Y[i]= boxGreen[i].getY();
        }
        return posBoxGreen_Y; // return posBoxGreen_Y
    }

    /*---------------- get X-Positions Goal -----------*/
    public float[] GetPosGoal_X(ImageView[] goal, float[] posGoal_X, int nrBox){
        for (int i = 0; i < nrBox; i++) {
            posGoal_X[i]= goal[i].getX();
        }
        return posGoal_X; // return posGoal_X
    }

    /*---------------- get Y-Positions Goal -----------*/
    public float[] GetPosGoal_Y(ImageView[] goal, float[] posGoal_Y, int nrBox){
        for (int i = 0; i < nrBox; i++) {
            posGoal_Y[i]= goal[i].getY();
        }
        return posGoal_Y; // return posGoal_Y
    }
}
