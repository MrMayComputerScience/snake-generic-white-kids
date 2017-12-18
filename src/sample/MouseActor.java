package sample;

import com.sun.istack.internal.Nullable;
import mayflower.*;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MouseActor extends Actor {
    public static final int TICK_TIME = 75;
    private double numTicks, sumTimes = 0;
    private Timer t = new Timer();

    private double time;
    private long timeLastUpdate;
    private int tickLen;
    private int upControl;
    private int downControl;
    private int leftControl;
    private int rightControl;
    private int id;
    private boolean running;
    private World myWorld;

    public MouseActor(int di) {
        id = di;
        tickLen = TICK_TIME;
        timeLastUpdate = -2;
        time = 0.0;
        running = false;
        if (id == 1) setImage("peachp.png");
        else if (id == 2) setImage("peachg.png");
        else if (id == 3) setImage("peachy.png");
        else if (id == 4) setImage("peachr.png");
        t = new Timer(Integer.MAX_VALUE);

    }
    public void setControls(int up, int down, int left, int right ){
        setUpControl(up);
        setDownControl(down);
        setLeftControl(left);
        setRightControl(right);
    }
    public void setUpControl(int keyboard) {
        upControl = keyboard;
    }

    public void setDownControl(int keyboard) {
        downControl = keyboard;
    }

    public void setLeftControl(int keyboard) {
        leftControl = keyboard;
    }

    public void setRightControl(int keyboard) {
        rightControl = keyboard;
    }

    public int getId() {
        return id;
    }

    public void act() {
        if (getWorld() != null)
            myWorld = getWorld();
        if (timeLastUpdate == -1) {
            timeLastUpdate = System.currentTimeMillis();
            t.reset();
        }
        if (t.isDone()) {
            int trueTime = (int) (System.currentTimeMillis() - timeLastUpdate);
            int diff = trueTime - tickLen;
            tickLen = TICK_TIME - diff;
            sumTimes += trueTime;
            numTicks++;
            t.set(TICK_TIME - diff);
            timeLastUpdate = System.currentTimeMillis();
            //int headX = getX();
            //int headY = getY();
            //int headRot = getRotation();

            t.reset();
            moveMouse();
            time++;
            //System.out.println(t.toString());
            move(20);




        }
        if(isTouching(SvMSnakeActor.class)) {
            myWorld = getWorld();
            if (isTouching(SvMSnakeActor.class)) {
                myWorld.removeObject(this);
            }
        }
        if (isTouching(wall.class)) {
                move(-20);
            }

    }



    public void moveMouse() {
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



    public double getTime() {
        double ntime = (time * 75) / 1000;
        return ntime;
    }






    public void startTimer() {
        t.set(75);
        timeLastUpdate = -1;
        running = true;
    }

    public boolean isPressing() {
        if (Mayflower.isKeyDown(upControl) || Mayflower.isKeyDown(downControl) || Mayflower.isKeyDown(leftControl) || Mayflower.isKeyDown(rightControl)) {
            //running = true;
            return true;
        } else {
            //running = false;
            return false;
        }
    }

    public boolean getRunning() {
        return running;
    }
}