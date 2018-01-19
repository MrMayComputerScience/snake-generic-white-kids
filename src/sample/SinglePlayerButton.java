package sample;

import mayflower.*;

public class SinglePlayerButton extends Button{
    private GameInfo info;
    public SinglePlayerButton(String name, GameInfo info){
        super(name);
        this.info = info;
        info.setNumPlayers(1);
    }
    public void OnClick(){
        peachStage stage = new peachStage(info);
        Mayflower.setWorld(new PortalSelectScreen(info, stage));
        Mayflower.setWorld(new PortalStage(info));
    }
}
