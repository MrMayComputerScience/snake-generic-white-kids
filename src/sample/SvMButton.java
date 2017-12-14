package sample;

import mayflower.*;

public class SvMButton extends Actor{
    private int players;
    private SnakeActor sa;
    public SvMButton(){
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
        Mayflower.setWorld(new SMMultiStage());

    }
}
