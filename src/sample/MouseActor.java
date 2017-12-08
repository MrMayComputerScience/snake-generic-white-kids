package sample;
import mayflower.*;
public class MouseActor extends Actor {
    private int upControl;
    private int downControl;
    private int leftControl;
    private int rightControl;

    public MouseActor(String name){
        MayflowerImage img = new MayflowerImage(name);
        img.scale(20,20);
        setImage(img);
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

    public void moveMouse(){
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

    public void act(){

    }
}
