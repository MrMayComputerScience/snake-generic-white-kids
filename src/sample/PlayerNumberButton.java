package sample;
import mayflower.*;

public abstract class PlayerNumberButton extends Actor{
    private int players;
    private GameInfo info;
   public PlayerNumberButton(String name, int player, GameInfo info){
       MayflowerImage img = new MayflowerImage(name);
       this.info = info;
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
        Mayflower.setWorld(new ControlsScreen(players, info));
    }

}


