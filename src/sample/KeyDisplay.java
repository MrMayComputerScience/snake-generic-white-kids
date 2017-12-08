package sample;
import mayflower.*;
public abstract class KeyDisplay extends Actor {
    private int key;
    public KeyDisplay(String name, int keynum){
        MayflowerImage img = new MayflowerImage(name);
        img.scale(75,75);
        setImage(img);
        key = keynum;
    }

    public void act(){
        if(Mayflower.isKeyDown(key)){
            onPress();
        }
        if(!Mayflower.isKeyDown(key)){
            onRelease();
        }
    }
    public abstract void onPress();
    public abstract void onRelease();
}
