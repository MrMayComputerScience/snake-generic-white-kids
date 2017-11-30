package sample;
import mayflower.*;
public abstract class PlayerNumberButton extends Actor{
    private int players;
   public PlayerNumberButton(String name, int players){
       MayflowerImage img = new MayflowerImage(name);
       img.scale(150,150);
       setImage(img);
   }
    public void act(){
        if(Mayflower.mouseClicked(this)){
            OnClick();
        }
    }

    public int OnClick(){
        Mayflower.setWorld(new ModeMenu());
        return players;
    }

}


