package sample;
import mayflower.*;
public class ContinueButton extends Actor {
    private int players;
    public ContinueButton(String name, int x){
        players = x;
        MayflowerImage img = new MayflowerImage(name);
        img.scale(75,75);
        setImage(img);

    }
    public void act(){
        if(Mayflower.mouseClicked(this)){
            OnClick();
        }
    }
    public void OnClick(){
        Mayflower.setWorld(new ModeMenu(players));
    }
}
