package sample;
import mayflower.*;
public class GDisplay extends KeyDisplay {
    public GDisplay(String name, int keynum){super(name, keynum);}
    public void onPress(){
        MayflowerImage img = new MayflowerImage("Gr.png");
        img.scale(25,25);
        setImage(img);

    }
    public void onRelease(){
        MayflowerImage img = new MayflowerImage("G.png");
        img.scale(25,25);
        setImage(img);
    }
}