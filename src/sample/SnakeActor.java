package sample;

import com.sun.istack.internal.Nullable;
import mayflower.*;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


public class SnakeActor extends Actor{
    public static final int TICK_TIME = 75;
    private double numTicks, sumTimes = 0;
    private Timer t = new Timer();
    private int tailLength;
    private double time;
    private int lengthToAdd;
    private List<SnakeTail> tail;
    private long timeLastUpdate;
    private int tickLen;
    private int upControl;
    private int downControl;
    private int leftControl;
    private int rightControl;
    private int id;
    public SnakeActor(int di)
    {
        id = di;
        tickLen = TICK_TIME;
        timeLastUpdate = -1;
        lengthToAdd = 1;
        tail = new ArrayList<>();
        time = 0.0;
        tailLength = 0;
        setImage("eggplantsnake.jpg");
        t = new Timer(TICK_TIME);
    }
    public void setUpControl(int keyboard){
        upControl = keyboard;
    }
    public void setDownControl(int keyboard){
        downControl = keyboard;
    }
    public void setLeftControl(int keyboard){
        leftControl = keyboard;
    }
    public void setRightControl(int keyboard){
        rightControl = keyboard;
    }

    public void act(){
        if(timeLastUpdate == -1){
            timeLastUpdate = System.currentTimeMillis();
            t.reset();
        }

        if(Mayflower.isKeyPressed(Keyboard.KEY_ADD)){
 
            if(Mayflower.isKeyDown(Keyboard.KEY_LSHIFT) || Mayflower.isKeyDown(Keyboard.KEY_RSHIFT)){
                System.out.println("Shifted");
                lengthToAdd += 10;
            }
            else if(Mayflower.isKeyDown(Keyboard.KEY_LCONTROL) || Mayflower.isKeyDown(Keyboard.KEY_RCONTROL)){
                lengthToAdd += 1500;
            }
            else
                lengthToAdd++;
        }
        if(Mayflower.isKeyPressed(Keyboard.KEY_EQUALS) ){
            if(Mayflower.isKeyDown(Keyboard.KEY_LSHIFT) || Mayflower.isKeyDown(Keyboard.KEY_RSHIFT)){
                if(Mayflower.isKeyDown(Keyboard.KEY_LCONTROL) || Mayflower.isKeyDown(Keyboard.KEY_RCONTROL)){
                    lengthToAdd += 1500;
                }
                else
                    lengthToAdd += 10;
            }
        }
        if(Mayflower.isKeyPressed(Keyboard.KEY_SUBTRACT) || Mayflower.isKeyPressed(Keyboard.KEY_MINUS)){

            if(Mayflower.isKeyDown(Keyboard.KEY_LSHIFT) || Mayflower.isKeyDown(Keyboard.KEY_RSHIFT)){
                System.out.println("Shifted");
                lengthToAdd -= 10;
            }
            else if(Mayflower.isKeyDown(Keyboard.KEY_LCONTROL) || Mayflower.isKeyDown(Keyboard.KEY_RCONTROL)){
                lengthToAdd -= 1500;
            }
            else
                lengthToAdd--;
        }

        if(t.isDone()){
            int trueTime = (int)(System.currentTimeMillis() - timeLastUpdate);
            int diff = trueTime - tickLen;
            tickLen = TICK_TIME - diff;
            sumTimes += trueTime;
            numTicks++;
            t.set(TICK_TIME - diff);
            timeLastUpdate = System.currentTimeMillis();
            int headX = getX();
            int headY = getY();
            int headRot = getRotation();
            bigify();
            t.reset();
            if (Mayflower.isKeyDown(upControl)) {
                setRotation(Direction.NORTH);
            } else if (Mayflower.isKeyDown(downControl)) {
                setRotation(Direction.SOUTH);
            } else if (Mayflower.isKeyDown(leftControl)) {
                setRotation(Direction.WEST);
            } else if (Mayflower.isKeyDown(rightControl)) {
                setRotation(Direction.EAST);
            }
            if(Math.abs(getRotation()-headRot) % 180 == 0 && tailLength >= 2)
                setRotation(headRot);
            time++;
            //System.out.println(t.toString());
            move(20);
            handleTail(headX, headY, headRot);
            eatPeach(detectPeach());


        }
        if(isTouching(wall.class) || isTouching(SnakeTail.class) || isTouching(SnakeActor.class)){
            Mayflower.setWorld(new InitialsInput(this));
        }

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

    public double getTime(){
        double ntime = (time*75)/1000;
        return ntime;
    }
    public String getRatio(){

        double d = (double)(getTailLength()/getTime());
        System.out.println("Ratio: "+d+"Length: "+getTailLength()+" Time: "+getTime());
        return String.format("%.3f", d);

    }
    public void handleTail(int headX, int headY, int headRot){
        int prevX = headX;
        int prevY = headY;
        int prevRot = headRot;
        for(SnakeTail t : tail){
            int tempX = t.getX();
            int tempY = t.getY();
            int tempRot = t.getRotation();
            t.setLocation(prevX, prevY);
            t.setRotation(prevRot);
            prevX = tempX;
            prevY = tempY;
            prevRot = tempRot;
        }
        if(getIntersectingObjects(this.getClass()).contains(new wall()))
        {
            this.getWorld().removeObject(this);
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
        tailLength += lengthToAdd;
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