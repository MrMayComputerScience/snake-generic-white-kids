package sample;

import mayflower.*;

public class TwitchPlaysButton extends Actor{
    private int players;
    private SnakeActor sa;
    private GameInfo info;
    public TwitchPlaysButton(int x, GameInfo info){
        this.info = info;


    public TwitchPlaysButton(int x, GameInfo info){
        this.info = info;
        players = x;
        MayflowerImage img = new MayflowerImage("TwitchPlays.png");
        img.scale(150,150);
        setImage(img);
        sa = new TwitchSnakeActor(players, 1, info);
    }
    public void act(){
        if(Mayflower.mouseClicked(this)){
            onClick();
        }
    }
    public void onClick(){
        peachStage ps = new peachStage(info);
        ps.setSnek(sa);
        Mayflower.setWorld(new PortalSelectScreen(info, ps));

    }
}
