package sample;

import mayflower.*;

public class SvMButton extends Actor{
    private int players;
    private SnakeActor sa;
    private GameInfo info;
    public SvMButton(GameInfo info){
        this.info = info;
        MayflowerImage img = new MayflowerImage("svm.png");
        img.scale(150,150);
        setImage(img);
    }
    public void act(){
        if(Mayflower.mouseClicked(this)){
            onClick();
        }
    }
    public void onClick(){
        SMMultiStage stage = new SMMultiStage(info);
        Mayflower.setWorld(new PortalSelectScreen(info, stage));

    }
}
