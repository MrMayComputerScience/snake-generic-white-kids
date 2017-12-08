package sample;
import mayflower.*;
public class ADisplay extends KeyDisplay{
    public ADisplay(String name, int keynum){super(name, keynum);}
    public void onPress(){
        MayflowerImage img = new MayflowerImage("Ar.png");
        img.scale(25,25);
        setImage(img);

    }
    public void onRelease(){
        MayflowerImage img = new MayflowerImage("A.png");
        img.scale(25,25);
        setImage(img);
    }
}
