package sample;
import mayflower.*;
public class SDisplay extends KeyDisplay{
    public SDisplay(String name, int keynum){super(name, keynum);}
    public void onPress(){
        MayflowerImage img = new MayflowerImage("Sr.png");
        img.scale(25,25);
        setImage(img);

    }
    public void onRelease(){
        MayflowerImage img = new MayflowerImage("S.png");
        img.scale(25,25);
        setImage(img);
    }
}
