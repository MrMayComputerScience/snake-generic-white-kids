package sample;

import mayflower.*;
public class Runner extends Mayflower{

    public Runner() {
        super("Snake", 806, 628);
        // TODO Auto-generated constructor stub
    }
    public void init(){
        Mayflower.setFullScreen(false);
        GameInfo info = new GameInfo();
        World startingWorld = new titleStage(info);
        Mayflower.setWorld(startingWorld);
       // Mayflower.showFPS(true);
    }
    public static void main(String[] args){
        try{
            new Runner();
        }
        catch(java.lang.UnsupportedOperationException e){

        }
    }
}