package sample;

import com.sun.istack.internal.Nullable;
import mayflower.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class SnakeActor extends Actor{
    private Timer t = new Timer();
    private int tailLength;
    private List<SnakeTail> tail;
    public SnakeActor()
    {
        tail = new ArrayList<>();
        tailLength = 0;
        setImage("eggplantsnake.jpg");
        t = new Timer(75);
    }

    public void act(){

        if (Mayflower.isKeyDown(Keyboard.KEY_UP) || Mayflower.isKeyDown(Keyboard.KEY_W)) {
            setRotation(Direction.NORTH);
        }
        else if (Mayflower.isKeyDown(Keyboard.KEY_DOWN) || Mayflower.isKeyDown(Keyboard.KEY_S)) {
            setRotation(Direction.SOUTH);
        }
        else if (Mayflower.isKeyDown(Keyboard.KEY_LEFT) || Mayflower.isKeyDown(Keyboard.KEY_A)) {
            setRotation(Direction.WEST);
        }
        else if (Mayflower.isKeyDown(Keyboard.KEY_RIGHT) || Mayflower.isKeyDown(Keyboard.KEY_D)) {
            setRotation(Direction.EAST);
        }
        if(t.isDone()){
            int headX = getX();
            int headY = getY();
            bigify();
            t.reset();
            move(20);
            handleTail(headX, headY);
            eatPeach(detectPeach());
        }
        if(isTouching(wall.class) || isTouching(SnakeTail.class)){
            Mayflower.setWorld(new InitialsInput(this));
        }
        System.out.println(getTailLength());
    }
    public void saveScore(String initials){
        try
        {
            File scoreFile = new File("scores.txt");
            File nameFile = new File("names.txt");
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
    public void handleTail(int headX, int headY){
        int prevX = headX;
        int prevY = headY;
        for(SnakeTail t : tail){
            int tempX = t.getX();
            int tempY = t.getY();
            t.setLocation(prevX, prevY);
            prevX = tempX;
            prevY = tempY;
        }
    }
    public Peach detectPeach(){
        if(getIntersectingObjects(Peach.class).size() > 0){
            return getIntersectingObjects(Peach.class).get(0);
        }
        return null;
    }
    public void eatPeach(@Nullable Peach peach){
        if(peach == null){
        //    System.out.println("Peach is null");
            return;
        }
        getWorld().removeObject(peach);
        tailLength++;
        Peach.addRandomPeach((peachStage)getWorld()); //Should never throw invalid cast errors
    }
    public void bigify(){
        if(tailLength > tail.size()){
            SnakeTail t = new SnakeTail();
            tail.add(t);
            getWorld().addObject(t,getX(),getY());
        }
    }
    public int getTailLength()
    {
        return tailLength;
    }
    class SnakeTail extends Actor{
        public SnakeTail(){
            setImage("eggplantsnake.jpg");
        }
        @Override
        public void act(){
        }
    }
}