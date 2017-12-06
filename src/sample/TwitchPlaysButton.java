package sample;

import mayflower.*;

public class TwitchPlaysButton extends Actor{
    private int players;
    private SnakeActor sa;
    public TwitchPlaysButton(int x){
        players = x;
        MayflowerImage img = new MayflowerImage("TwitchPlays.png");
        img.scale(150,150);
        setImage(img);
        sa = new TwitchSnakeActor(players);
    }
    public void act(){
        if(Mayflower.mouseClicked(this)){
            onClick();
        }
    }
    public void onClick(){
        peachStage ps = new peachStage();

        ps.setSnek(sa);
        Mayflower.setWorld(ps);

    }
}
