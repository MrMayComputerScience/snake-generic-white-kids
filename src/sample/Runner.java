package sample;

import mayflower.*;
public class Runner extends Mayflower{
    
    public Runner() {
        super("Snake", 800, 600);
        // TODO Auto-generated constructor stub
    }
    public void init(){
        Mayflower.setFullScreen(false);
        World startingWorld = new titleStage();
        Mayflower.setWorld(startingWorld);
       // Mayflower.showFPS(true);
    }
    public static void main(String[] args){
        new Runner();
    }
}