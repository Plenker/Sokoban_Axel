package com.sokoban;

import android.media.MediaPlayer;

public class Music {

    static int musicTitel;

    static int SetMusic(int nrLvl){
        if(nrLvl==1){
            musicTitel= R.raw.motivationa;
        }
        if(nrLvl==2){
            musicTitel= R.raw.epicaly;
        }
        if(nrLvl==3){
            musicTitel= R.raw.happyday;
        }
        if(nrLvl==4){
            musicTitel= R.raw.inspirational;
        }
        if(nrLvl==5){
            musicTitel= R.raw.minimal;
        }
        return musicTitel;
    }

}
