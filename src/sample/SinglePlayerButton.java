package sample;

import mayflower.*;

public class SinglePlayerButton extends Button{
    private GameInfo info;
    public SinglePlayerButton(String name, GameInfo inf){
        super(name);
        info = inf;
    }
    public void OnClick(){

        Mayflower.setWorld(new peachStage(info));


    }
}
