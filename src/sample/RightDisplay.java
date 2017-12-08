package sample;
import mayflower.*;
public class RightDisplay extends KeyDisplay{
    public RightDisplay(String name, int keynum){super(name, keynum);}
    public void onPress(){
        MayflowerImage img = new MayflowerImage("rightr.png");
        img.scale(25,25);
        setImage(img);

    }
    public void onRelease(){
        MayflowerImage img = new MayflowerImage("right.png");
        img.scale(25,25);
        setImage(img);
    }
}