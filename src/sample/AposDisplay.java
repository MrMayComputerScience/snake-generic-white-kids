package sample;
import mayflower.*;
public class AposDisplay extends KeyDisplay{
    public AposDisplay(String name, int keynum){super(name, keynum);}
    public void onPress(){
        MayflowerImage img = new MayflowerImage("apostropher.png");
        img.scale(25,25);
        setImage(img);

    }
    public void onRelease(){
        MayflowerImage img = new MayflowerImage("apostrophe.png");
        img.scale(25,25);
        setImage(img);
    }
}
