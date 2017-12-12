package sample;
import mayflower.*;
public class YDisplay extends KeyDisplay {
    public YDisplay(String name, int keynum){super(name, keynum);}
    public void onPress(){
        MayflowerImage img = new MayflowerImage("Yr.png");
        img.scale(25,25);
        setImage(img);

    }
    public void onRelease(){
        MayflowerImage img = new MayflowerImage("Y.png");
        img.scale(25,25);
        setImage(img);
    }
}
