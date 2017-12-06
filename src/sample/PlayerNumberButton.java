package sample;
import mayflower.*;
public abstract class PlayerNumberButton extends Actor{
    private int players;
   public PlayerNumberButton(String name, int player){
       MayflowerImage img = new MayflowerImage(name);
       img.scale(150,150);
       setImage(img);
       players = player;
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


