package sample;
import mayflower.*;

public abstract class Button extends Actor {
    public Button(String name){
        MayflowerImage img = new MayflowerImage(name);
        img.scale(150,75);
        setImage(img);
    }
    public void act(){
        if(Mayflower.mouseClicked(this)){
            OnClick();
        }
    }
    public abstract void OnClick();
}
