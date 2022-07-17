package com.sokoban;


public class Levels {


    static int[][] lvl_1 = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1},
            {1, 0, 0, 1, 0, 0, 2, 0, 0, 0, 0, 2, 0, 1, 0, 4, 0, 0, 1},
            {1, 1, 2, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1},
            {1, 3, 3, 1, 1, 0, 2, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 1},
            {1, 3, 3, 3, 1, 0, 0, 2, 0, 1, 2, 0, 0, 1, 0, 0, 2, 0, 1},
            {1, 3, 3, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
    }; // 1 = Wall // 2 = Box_brown & green // 3 = Goals // 4 = Player
    static int nrItemWall_1 = 120; // max number of the walls - the game also run, if less walls are placed, but not if more!
    static int nrItemBox_1 = 8; // important - the nr of the goals must be the same of the boxes!

    static int[][] lvl_2 = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
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
    static int nrItemWall_2 = 90; // max number of the walls - the game also run, if less walls are placed, but not if more!
    static int nrItemBox_2 = 5; // important - the nr of the goals must be the same of the boxes!

    static int[][] lvl_3 = {   {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {1, 0, 0, 0, 3, 1, 0, 0, 0, 1, 3, 0, 0, 0, 0, 0, 0, 1, 1},
            {1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 1},
            {1, 1, 0, 0, 2, 0, 3, 1, 0, 0, 1, 0, 0, 0, 3, 1, 0, 0, 1},
            {1, 0, 0, 2, 1, 1, 1, 1, 0, 0, 0, 2, 0, 0, 1, 3, 0, 0, 1},
            {1, 0, 1, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 1, 1, 1, 0, 0, 1},
            {1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 2, 0, 1, 3, 0, 0, 1},
            {1, 0, 1, 2, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 4, 0, 0, 0, 0, 0, 0, 3, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
    }; // 1 = Wall // 2 = Box_brown & green // 3 = Goals // 4 = Player
    static int nrItemWall_3 = 140; // max number of the walls - the game also run, if less walls are placed, but not if more!
    static int nrItemBox_3 = 7; // important - the nr of the goals must be the same of the boxes!

    static int[][] lvl_4 = {   {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {1, 3, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {1, 3, 0, 0, 0, 0, 0, 4, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1},
            {1, 0, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1},
            {1, 0, 0, 1, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 3, 1},
            {1, 1, 0, 1, 1, 1, 2, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 1, 3, 0, 0, 1, 0, 1, 0, 0, 0, 1},
            {1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 2, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
    }; // 1 = Wall // 2 = Box_brown & green // 3 = Goals // 4 = Player
    static int nrItemWall_4 = 120; // max number of the walls - the game also run, if less walls are placed, but not if more!
    static int nrItemBox_4 = 4; // important - the nr of the goals must be the same of the boxes!

    static int[][] lvl_5 = {   {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {1, 3, 2, 0, 3, 1, 3, 1, 3, 1, 3, 0, 0, 0, 0, 0, 3, 1, 1},
            {1, 0, 1, 1, 1, 1, 3, 1, 3, 1, 1, 0, 1, 1, 0, 0, 1, 3, 1},
            {1, 0, 2, 0, 3, 1, 0, 1, 0, 3, 1, 0, 0, 2, 0, 1, 1, 0, 1},
            {1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 1},
            {1, 0, 1, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 2, 0, 1, 1, 2, 1},
            {1, 0, 1, 0, 1, 0, 0, 2, 0, 1, 1, 0, 2, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 2, 1, 1, 1, 0, 0, 1, 0, 0, 2, 1, 1, 1, 2, 0, 1},
            {1, 3, 0, 0, 0, 0, 0, 0, 0, 1, 4, 0, 0, 0, 3, 1, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
    }; // 1 = Wall // 2 = Box_brown & green // 3 = Goals // 4 = Player
    static int nrItemWall_5 = 140; // max number of the walls - the game also run, if less walls are placed, but not if more!
    static int nrItemBox_5 = 13; // important - the nr of the goals must be the same of the boxes!

    static int nrMaxLvl =5;
    static int[] nrItemWall = {nrItemWall_1, nrItemWall_2, nrItemWall_3, nrItemWall_4, nrItemWall_5};// max number of the walls - the game also run, if less walls are placed, but not if more!
    static int[] nrItemBox = {nrItemBox_1, nrItemBox_2, nrItemBox_3, nrItemBox_4, nrItemBox_5}; // important - the nr of the goals must be the same of the boxes!

    static int[][] GetLvl_1() {return lvl_1;}
    static int[][] GetLvl_2() {return lvl_2;}
    static int[][] GetLvl_3() {return lvl_3;}
    static int[][] GetLvl_4() {return lvl_4;}
    static int[][] GetLvl_5() {return lvl_5;}

    static int GetNrMaxLevel(){return nrMaxLvl;}
    static int[] GetNrItemWalls(){return nrItemWall;}
    static int[] GetNrItemBoxes(){return nrItemBox;}

}
