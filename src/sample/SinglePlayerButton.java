package sample;

import mayflower.*;

public class SinglePlayerButton extends Button{
    private GameInfo info;
    public SinglePlayerButton(String name, GameInfo info){
        super(name);
        this.info = info;
    }
    public void OnClick(){
        SnakeActor snek = new SnakeActor(1);
        snek.setTronMode(false);
        peachStage stage = new peachStage(info);
        stage.setSnek(snek);
        Mayflower.setWorld(new PortalStage(info));

    }
}
