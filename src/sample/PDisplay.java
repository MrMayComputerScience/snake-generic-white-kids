package sample;
import mayflower.*;
public class PDisplay extends KeyDisplay{
    public PDisplay(String name, int keynum){super(name, keynum);}
    public void onPress(){
        MayflowerImage img = new MayflowerImage("PDisplay.png");
        img.scale(25,25);
        setImage(img);

    }
    public void onRelease(){
        MayflowerImage img = new MayflowerImage("P.png");
        img.scale(25,25);
        setImage(img);
    }
}
