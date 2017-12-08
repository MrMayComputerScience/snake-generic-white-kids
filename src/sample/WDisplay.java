package sample;
import mayflower.*;
public class WDisplay extends KeyDisplay {
    public WDisplay(String name, int keynum){super(name, keynum);}
    public void onPress(){
        MayflowerImage img = new MayflowerImage("Wr.png");
        img.scale(75,75);
        setImage(img);

    }
    public void onRelease(){
        MayflowerImage img = new MayflowerImage("W.png");
        img.scale(75,75);
        setImage(img);
    }

}
