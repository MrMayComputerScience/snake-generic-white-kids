package sample;
import mayflower.*;
public class ContinueButton extends Actor {
    private int players;
    private GameInfo info;
    public ContinueButton(String name, int x, GameInfo info){
        this.info = info;
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
        Mayflower.setWorld(new ModeMenu(players, info));
    }
}
