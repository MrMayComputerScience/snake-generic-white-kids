package sample;
import mayflower.*;
public class JDisplay extends KeyDisplay {
    public JDisplay(String name, int keynum){super(name, keynum);}
    public void onPress(){
        MayflowerImage img = new MayflowerImage("Jr.png");
        img.scale(25,25);
        setImage(img);

    }
    public void onRelease(){
        MayflowerImage img = new MayflowerImage("J.png");
        img.scale(25,25);
        setImage(img);
    }
}