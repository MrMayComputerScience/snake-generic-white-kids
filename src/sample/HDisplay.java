package sample;
import mayflower.*;
public class HDisplay extends KeyDisplay {
    public HDisplay(String name, int keynum){super(name, keynum);}
    public void onPress(){
        MayflowerImage img = new MayflowerImage("Hr.png");
        img.scale(25,25);
        setImage(img);

    }
    public void onRelease(){
        MayflowerImage img = new MayflowerImage("H.png");
        img.scale(25,25);
        setImage(img);
    }
}