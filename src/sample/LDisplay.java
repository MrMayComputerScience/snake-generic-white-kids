package sample;
import mayflower.*;
public class LDisplay extends KeyDisplay{
    public LDisplay(String name, int keynum){super(name, keynum);}
    public void onPress(){
        MayflowerImage img = new MayflowerImage("LDisplay.png");
        img.scale(25,25);
        setImage(img);

    }
    public void onRelease(){
        MayflowerImage img = new MayflowerImage("L.png");
        img.scale(25,25);
        setImage(img);
    }
}
