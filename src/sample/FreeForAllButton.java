package sample;
import mayflower.*;
public class FreeForAllButton extends Actor{
    private int players;
    public FreeForAllButton(int x){
        MayflowerImage img = new MayflowerImage("freeforall.png");
        img.scale(150,150);
        setImage(img);
        players = x;

    }
    public void act(){
        if(Mayflower.mouseClicked(this)){
            onClick();
        }
    }
    public void onClick(){
        Mayflower.setWorld(new MultiStage(players));
    }

}
