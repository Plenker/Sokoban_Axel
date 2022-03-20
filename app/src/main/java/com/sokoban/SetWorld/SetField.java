package com.sokoban.SetWorld;

import android.text.Layout;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.sokoban.R;

public class SetField {

    /*----------------------- Size of the Game Text---------------------*/
    public int SetGameTextSize(int dpWidth){
        int Size = dpWidth/20;
        double calc = Size * (1977.0 / dpWidth);
        Size = (int) calc;
        return Size;
    }

    /*----------------------- Set Walls ---------------------*/
    public ImageView[] SetWalls(RelativeLayout Layout, ImageView[] imgWall,int nrMax, int Base, int[][] field){
        int nrWall = 0;
        for (int e = 0; e < 10; e++) {
            for (int i = 0; i < field[e].length; i++) {
                if (field[e][i] == 1) {
                    imgWall[nrWall] = new ImageView(Layout.getContext()); //Definde my Walls Block with new Image View
                    Layout.addView(imgWall[nrWall]);    // set the Layout from the selected Level
                    imgWall[nrWall].setImageResource(R.drawable.img_item_wall); // set the Image from the Source
                    imgWall[nrWall].setLayoutParams(new RelativeLayout.LayoutParams(Base, Base)); //Set Size

                    imgWall[nrWall].setX(Base * i); // Set Position X
                    imgWall[nrWall].setY(Base * e); // Set Position Y
                    nrWall++;
                }
            }
        }

        /*------------------ Set Walls that are not defined in the play field to zero -------------------*/
        for (int i = nrWall; i < nrMax; i++) {
            imgWall[i] = new ImageView(Layout.getContext()); //Definde my Walls Block with new Image View
            Layout.addView(imgWall[i]);    // set the Layout from the selected Level
            imgWall[i].setImageResource(R.drawable.img_item_wall); // set the Image from the Source
            imgWall[i].setLayoutParams(new RelativeLayout.LayoutParams(Base, Base)); //Set Size
            imgWall[i].setX(0); // Set Position X
            imgWall[i].setY(0); // Set Position Y
            imgWall[i].setVisibility(View.INVISIBLE);
        }
        return imgWall; // return Wall Arrray
    }

    /*----------------------- Set Brown Boxes ---------------------*/
    public ImageView[] SetBoxBrown(RelativeLayout Layout, ImageView[] imgBoxBrown, int Base, int[][] field){
        int nrBoxBrown = 0;
        for (int e = 0; e < 10; e++) {
            for (int i = 0; i < field[e].length; i++) {
                if (field[e][i] == 2) {
                    imgBoxBrown[nrBoxBrown] = new ImageView(Layout.getContext()); //Definde my Brown Box Block with new Image View
                    Layout.addView(imgBoxBrown[nrBoxBrown]);    // set the Layout from the selected Level
                    imgBoxBrown[nrBoxBrown].setImageResource(R.drawable.img_item_box_brown); // set the Image from the Source
                    imgBoxBrown[nrBoxBrown].setLayoutParams(new RelativeLayout.LayoutParams(Base, Base)); //Set Size

                    imgBoxBrown[nrBoxBrown].setX(Base * i); // Set Position X
                    imgBoxBrown[nrBoxBrown].setY(Base * e); // Set Position Y
                    nrBoxBrown++;
                }
            }
        }
        return imgBoxBrown; // return Brown Box Arrray
    }

    /*----------------------- Set Green Boxes ---------------------*/
    public ImageView[] SetBoxGreen(RelativeLayout Layout, ImageView[] imgBoxGreen, int Base, int[][] field){
        int nrBoxGreen = 0;
        for (int e = 0; e < 10; e++) {
            for (int i = 0; i < field[e].length; i++) {
                if (field[e][i] == 2) {
                    imgBoxGreen[nrBoxGreen] = new ImageView(Layout.getContext()); //Definde my Brown Box Block with new Image View
                    Layout.addView(imgBoxGreen[nrBoxGreen]);    // set the Layout from the selected Level
                    imgBoxGreen[nrBoxGreen].setImageResource(R.drawable.img_item_box_green); // set the Image from the Source
                    imgBoxGreen[nrBoxGreen].setLayoutParams(new RelativeLayout.LayoutParams(Base, Base)); //Set Size
                    imgBoxGreen[nrBoxGreen].setX(0); // Set Position X
                    imgBoxGreen[nrBoxGreen].setY(0); // Set Position Y
                    imgBoxGreen[nrBoxGreen].setVisibility(View.INVISIBLE); // initial invisible - get visible if brown box hit a goal
                    nrBoxGreen++;
                }
            }
        }
        return imgBoxGreen; // return Brown Box Arrray
    }

    /*----------------------- Set Goals ---------------------*/
    public ImageView[] SetGoals(RelativeLayout Layout, ImageView[] imgGoal, int Base, int[][] field){
        int nrGoals = 0;
        for (int e = 0; e < 10; e++) {
            for (int i = 0; i < field[e].length; i++) {
                if (field[e][i] == 3) {
                    imgGoal[nrGoals] = new ImageView(Layout.getContext()); //Definde my Brown Box Block with new Image View
                    Layout.addView(imgGoal[nrGoals]);    // set the Layout from the selected Level
                    imgGoal[nrGoals].setImageResource(R.drawable.img_item_goal); // set the Image from the Source
                    imgGoal[nrGoals].setLayoutParams(new RelativeLayout.LayoutParams(Base, Base)); //Set Size
                    imgGoal[nrGoals].setX(Base * i); // Set Position X
                    imgGoal[nrGoals].setY(Base * e); // Set Position Y
                    nrGoals++;
                }
            }
        }
        return imgGoal; // return Brown Box Arrray
    }

    /*----------------------- Set Player position ---------------------*/
    public ImageView SetPlayer(RelativeLayout Layout, ImageView player, int Base, int[][] field){
        for (int e = 0; e < 10; e++) {
            for (int i = 0; i < field[e].length; i++) {
                if (field[e][i] == 4) {
                    player = new ImageView(Layout.getContext()); //Definde my Brown Box Block with new Image View
                    Layout.addView(player);    // set the Layout from the selected Level
                    player.setImageResource(R.drawable.img_player_down_01); // set the Image from the Source
                    player.setLayoutParams(new RelativeLayout.LayoutParams(Base, Base)); //Set Size
                    player.setX(Base * i); // Set Position X
                    player.setY(Base * e); // Set Position Y
                }
            }
        }
        return player; // return player
    }

    /*----------------------- Set the Star ---------------------*/
    public ImageView SetStar(RelativeLayout Layout, ImageView star, int Base){
        star = new ImageView(Layout.getContext()); //Definde my Brown Box Block with new Image View
        Layout.addView(star);    // set the Layout from the selected Level
        star.setImageResource(R.drawable.img_star); // set the Image from the Source
        star.setLayoutParams(new RelativeLayout.LayoutParams(Base*5, Base*5)); //Set Size
        star.setX(Base * 7); // Set Position X
        star.setY(0); // Set Position Y
        star.setVisibility(View.INVISIBLE);

        return star; // return player
    }

}
