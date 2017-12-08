package sample;
import mayflower.*;
public class KeyActor extends Actor {
    public KeyActor(String name){
        MayflowerImage img = new MayflowerImage(name);
        img.scale(75,75);
        setImage(img);
    }

    public void act(){}
}
