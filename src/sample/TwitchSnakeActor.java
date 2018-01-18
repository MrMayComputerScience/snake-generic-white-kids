package sample;

import mayflower.*;
import sample.SnakeActor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TwitchSnakeActor extends SnakeActor {
    private int num;
    private boolean isRunning;
    private boolean wasRunning;
    public TwitchSnakeActor(int numPlayers, int id, GameInfo info){
        super(id, info);
        isRunning = false;
        wasRunning = false;
        num = numPlayers;
    }
    public void moveSnake(String direction){
        if(num == 3){
            if(direction.equals("p1up")){
                setRotation(Direction.NORTH);
                isRunning = true;
            }
            else if(direction.equals("p1Down")){
                setRotation(Direction.SOUTH);
                isRunning = true;
            }
            else if(direction.equals("p1left")){
                setRotation(Direction.WEST);
                isRunning = true;
            }
            else if(direction.equals("p1right")){
                setRotation(Direction.EAST);
                isRunning = true;
            }
        }
        if(num == 4){
            if(Mayflower.isKeyDown(Keyboard.KEY_W) && Mayflower.isKeyDown(Keyboard.KEY_Y) && Mayflower.isKeyDown(Keyboard.KEY_P) && Mayflower.isKeyDown(Keyboard.KEY_UP)){
                setRotation(Direction.NORTH);
                isRunning = true;
            }
            else if(Mayflower.isKeyDown(Keyboard.KEY_S) && Mayflower.isKeyDown(Keyboard.KEY_H) && Mayflower.isKeyDown(Keyboard.KEY_SEMICOLON) && Mayflower.isKeyDown(Keyboard.KEY_DOWN)){
                setRotation(Direction.SOUTH);
                isRunning = true;
            }
            else if(Mayflower.isKeyDown(Keyboard.KEY_A) && Mayflower.isKeyDown(Keyboard.KEY_G) && Mayflower.isKeyDown(Keyboard.KEY_L) && Mayflower.isKeyDown(Keyboard.KEY_LEFT)){
                setRotation(Direction.WEST);
                isRunning = true;
            }
            else if(Mayflower.isKeyDown(Keyboard.KEY_D) && Mayflower.isKeyDown(Keyboard.KEY_J) && Mayflower.isKeyDown(Keyboard.KEY_APOSTROPHE) && Mayflower.isKeyDown(Keyboard.KEY_RIGHT)){
                setRotation(Direction.EAST);
                isRunning = true;
            }
        }
        if(wasRunning != isRunning){
            startTimer();
            System.out.println("DIFF");
        }
        wasRunning = isRunning;

    }
    public int getNumPlayers(){
        return num;
    }
    @Override
    public void saveScore(String initials){
        try
        {
            File scoreFile = new File("twitch_scores.txt");
            File nameFile = new File("twitch_names.txt");
            FileWriter scoreWriter = new FileWriter(scoreFile, true);
            FileWriter nameWriter = new FileWriter(nameFile, true);
            scoreWriter.write("\r\n");
            scoreWriter.write(Integer.toString(getTailLength()));
            scoreWriter.close();
            nameWriter.write("\r\n");
            nameWriter.write(initials);
            nameWriter.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();

        }
    }
    @Override
    public void act(){
        super.act();
        if(!isRunning)
            moveSnake();
    }
}
