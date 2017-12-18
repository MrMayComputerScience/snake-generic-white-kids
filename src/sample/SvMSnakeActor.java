package sample;
import mayflower.*;

import java.util.ArrayList;
import java.util.List;

public class SvMSnakeActor extends Actor{
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
    private boolean running;
    private World myWorld;
    private int counter;
    public SvMSnakeActor(int di){
        id = di;
        int counter = 0;
        tickLen = TICK_TIME;
        timeLastUpdate = -2;
        lengthToAdd = 1;
        tail = new ArrayList<>();
        time = 0.0;
        tailLength = 0;
        running = false;
        if(id == 1)setImage("eggplantsnakep.jpg");
        else if(id == 2)setImage("eggplantsnakeg.jpg");
        else if(id == 3)setImage("eggplantsnakey.jpg");
        else if(id == 4)setImage("eggplantsnaker.jpg");
        t = new Timer(Integer.MAX_VALUE);


    }

    public void act(){
        if(getWorld() != null)
            myWorld = getWorld();
        if(timeLastUpdate == -1){
            timeLastUpdate = System.currentTimeMillis();
            t.reset();
        }
        if(t.isDone()){
            counter++;
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
            if(counter % 67 == 0){
                tailLength++;

            }
            bigify();
            t.reset();
            moveSnake();
            if(Math.abs(getRotation()-headRot) % 180 == 0 && tailLength >= 2)
                setRotation(headRot);
            time++;
            //System.out.println(t.toString());
            move(20);
            handleTail(headX, headY, headRot);


        }
        if(isTouching(MouseActor.class)){
            for(MouseActor m : getIntersectingObjects(MouseActor.class)){
                getWorld().removeObject(m);
                tailLength++;
            }
        }
        if(isTouching(wall.class)){
            move(-20);
        }
    }
    public void setControls(int up, int down, int left, int right ){
        setUpControl(up);
        setDownControl(down);
        setLeftControl(left);
        setRightControl(right);
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
    public int getId(){
        return id;
    }
    public void removeTail(){
        for(SnakeTail t : tail){
            myWorld.removeObject(t);
        }
    }
    public void moveSnake(){
        if (Mayflower.isKeyDown(upControl)) {
            setRotation(Direction.NORTH);
        } else if (Mayflower.isKeyDown(downControl)) {
            setRotation(Direction.SOUTH);
        } else if (Mayflower.isKeyDown(leftControl)) {
            setRotation(Direction.WEST);
        } else if (Mayflower.isKeyDown(rightControl)) {
            setRotation(Direction.EAST);
        }
    }
    public void bigify(){
        if(tailLength > tail.size()){
            SnakeTail t = new SnakeTail();
            tail.add(t);
            getWorld().addObject(t,getX(),getY());
        }
    }

    public double getTime(){
        double ntime = (time*75)/1000;
        return ntime;
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


    }


    public int getTailLength()
    {
        return tailLength;
    }
    public void startTimer()
    {
        t.set(75);
        timeLastUpdate = -1;
    }
    public boolean isPressing()
    {
        if(Mayflower.isKeyDown(upControl) || Mayflower.isKeyDown(downControl) || Mayflower.isKeyDown(leftControl) || Mayflower.isKeyDown(rightControl)){
            running = true;
            return true;
        }
        else {running = false; return false;}
    }
    public boolean getRunning()
    {
        return running;
    }
    class SnakeTail extends Actor{
        public SnakeTail(){

            if(id == 1)setImage("eggplantsnakep.jpg");
            else if(id == 2)setImage("eggplantsnakeg.jpg");
            else if(id == 3)setImage("eggplantsnakey.jpg");
            else if(id == 4)setImage("eggplantsnaker.jpg");
        }
        @Override
        public void act(){
            if(isTouching(MouseActor.class)){
                for(MouseActor m : getIntersectingObjects(MouseActor.class)){
                    getWorld().removeObject(m);
                    tailLength++;
                }
            }
        }
    }

}
