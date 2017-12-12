package sample;
import mayflower.*;
public class SemiDisplay extends KeyDisplay{
    public SemiDisplay(String name, int keynum){super(name, keynum);}
    public void onPress(){
        MayflowerImage img = new MayflowerImage("Semir.png");
        img.scale(25,25);
        setImage(img);

    }
    public void onRelease(){
        MayflowerImage img = new MayflowerImage("semicolon.png");
        img.scale(25,25);
        setImage(img);
    }
}
