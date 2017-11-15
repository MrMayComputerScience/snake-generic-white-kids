package sample;

import mayflower.Mayflower;

public class HighScoreButton extends Button {
    public HighScoreButton(String name){
        super(name);
    }
    public void OnClick(){
        Mayflower.setWorld(new highScoreStage());
    }
}
