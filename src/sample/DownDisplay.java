package sample;
import mayflower.*;
public class DownDisplay extends KeyDisplay{
    public DownDisplay(String name, int keynum){super(name, keynum);}
    public void onPress(){
        MayflowerImage img = new MayflowerImage("downr.png");
        img.scale(25,25);
        setImage(img);

    }
    public void onRelease(){
        MayflowerImage img = new MayflowerImage("down.png");
        img.scale(25,25);
        setImage(img);
    }
}