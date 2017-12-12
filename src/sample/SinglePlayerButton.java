package sample;

import mayflower.*;

public class SinglePlayerButton extends Button{
    public SinglePlayerButton(String name){
        super(name);
    }
    public void OnClick(){
        SnakeActor snek = new SnakeActor(1);
        snek.setTronMode(false);
        peachStage stage = new peachStage();
        stage.setSnek(snek);
        Mayflower.setWorld(new PortalStage());
    }
}
