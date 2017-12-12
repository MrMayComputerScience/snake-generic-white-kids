package sample;
import mayflower.*;
public class DDisplay extends KeyDisplay{
    public DDisplay(String name, int keynum){super(name, keynum);}
    public void onPress(){
        MayflowerImage img = new MayflowerImage("Dr.png");
        img.scale(25,25);
        setImage(img);

    }
    public void onRelease(){
        MayflowerImage img = new MayflowerImage("D.png");
        img.scale(25,25);
        setImage(img);
    }
}
