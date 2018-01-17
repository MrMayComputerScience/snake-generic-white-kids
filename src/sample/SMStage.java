package sample;


import mayflower.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class SMStage extends World{
    enum StageObject{
        WALL,
        SNAKE,
        MOUSE
    }
    private SvMSnakeActor snek1;
    private StageObject[][] peachGrid = new StageObject[30][40];
    private final int multiplier = 20;
    public SMStage(){
        for(int r = 0; r < 30; r++)
        {
            for(int c = 0; c < 40; c++)
            {
                if(r == 0 || r == 29 || c == 0 || c == 39)
                {
                    peachGrid[r][c] = StageObject.WALL;
                    addObject(new wall(), c* multiplier, r* multiplier);
                }
            }
        }
    }
    public void setSnek(SvMSnakeActor sa, int id){
        removeObject(snek1);
        snek1 = sa;
        int randomNum = 1 + (int)(Math.random()*40);
        addObject(snek1, 40, 40);
    }


    public void updateStage()
    {

    }




    @Override
    public void act() {
        detectWin();
    }
    protected void detectWin(){

    }
    public StageObject[][] getGrid() {
        return peachGrid;
    }
    public SvMSnakeActor getSnek() {
        return snek1;
    }



}
