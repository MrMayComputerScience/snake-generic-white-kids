package sample;
import mayflower.*;
public class LeftDisplay extends KeyDisplay{
    public LeftDisplay(String name, int keynum){super(name, keynum);}
    public void onPress(){
        MayflowerImage img = new MayflowerImage("leftr.png");
        img.scale(25,25);
        setImage(img);

    }
    public void onRelease(){
        MayflowerImage img = new MayflowerImage("left.png");
        img.scale(25,25);
        setImage(img);
    }
}