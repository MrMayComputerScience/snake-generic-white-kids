package sample;
import mayflower.*;
public class UpDisplay extends KeyDisplay{
    public UpDisplay(String name, int keynum){super(name, keynum);}
    public void onPress(){
        MayflowerImage img = new MayflowerImage("upr.png");
        img.scale(25,25);
        setImage(img);

    }
    public void onRelease(){
        MayflowerImage img = new MayflowerImage("up.png");
        img.scale(25,25);
        setImage(img);
    }
}