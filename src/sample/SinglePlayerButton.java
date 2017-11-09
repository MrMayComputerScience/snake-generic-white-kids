package sample;

import mayflower.*;

public class SinglePlayerButton extends Button{
    public SinglePlayerButton(String name){
        super(name);
    }
    public void OnClick(){

        Mayflower.setWorld(new PeachStage());


    }
}
