package sample;

import com.sun.istack.internal.Nullable;
import mayflower.*;

import java.text.DecimalFormat;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


public class SnakeActor extends Actor{
    private Timer t = new Timer();
    private int tailLength;
    private double time;
    private List<SnakeTail> tail;
    public SnakeActor()
    {
        tail = new ArrayList<>();
        time = 0.0;
        tailLength = 0;
        setImage("eggplantsnake.jpg");
        t = new Timer(75);
    }


    public void act(){


        if(t.isDone()){
            int headX = getX();
            int headY = getY();
            bigify();
            t.reset();


            if (Mayflower.isKeyDown(Keyboard.KEY_UP) || Mayflower.isKeyDown(Keyboard.KEY_W)) {
                setRotation(Direction.NORTH);
            } else if (Mayflower.isKeyDown(Keyboard.KEY_DOWN) || Mayflower.isKeyDown(Keyboard.KEY_S)) {
                setRotation(Direction.SOUTH);
            } else if (Mayflower.isKeyDown(Keyboard.KEY_LEFT) || Mayflower.isKeyDown(Keyboard.KEY_A)) {
                setRotation(Direction.WEST);
            } else if (Mayflower.isKeyDown(Keyboard.KEY_RIGHT) || Mayflower.isKeyDown(Keyboard.KEY_D)) {
                setRotation(Direction.EAST);
            }
            time++;
            //System.out.println(t.toString());
            move(20);
            handleTail(headX, headY);
            eatPeach(detectPeach());


        }
        if(isTouching(wall.class) || isTouching(SnakeTail.class)){
            Mayflower.setWorld(new gameOverScreen(this));

        }
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

        if(isTouching(wall.class) || isTouching(SnakeTail.class)){
            Mayflower.setWorld(new gameOverScreen());
            try
            {
                File test = new File("scores.txt");
                FileWriter pw = new FileWriter(test, true);
                pw.write("\r\n");
                pw.write(Integer.toString(getTailLength()));
                pw.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        System.out.println(getTailLength());
    }

    public double getTime(){
        time = (time*75)/1000;
        return time;
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
        if(getIntersectingObjects(this.getClass()).contains(new wall()))
        {
            Mayflower.setWorld(new gameOverScreen(this));
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
        Peach.addRandomPeach((PeachStage)getWorld()); //Should never throw invalid cast errors
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