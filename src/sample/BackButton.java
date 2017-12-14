package sample;
import mayflower.*;
public class BackButton extends Actor {
    private GameInfo info;
    public BackButton(String name, GameInfo inf){
        info = inf;
        MayflowerImage img = new MayflowerImage(name);
        img.scale(75,75);
        setImage(img);
    }

    public void act(){
        if(Mayflower.mouseClicked(this)){
            OnClick();
        }
    }
    public void OnClick(){Mayflower.setWorld(new titleStage(info));}


}
