package sample;
import mayflower.*;
public class WDisplay extends KeyDisplay {
    public WDisplay(String name, int keynum){super(name, keynum);}
    public void onPress(){
        MayflowerImage img = new MayflowerImage("Wr.png");
        img.scale(25,25);
        setImage(img);

    }
    public void onRelease(){
        MayflowerImage img = new MayflowerImage("W.png");
        img.scale(25,25);
        setImage(img);
    }

}
