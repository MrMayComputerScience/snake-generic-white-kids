package sample;

import mayflower.Mayflower;

public class HighScoreButton extends Button {
    private GameInfo info;
    public HighScoreButton(String name, GameInfo info){
        super(name);
        this.info = info;
    }
    public void OnClick(){
        Mayflower.setWorld(new highScoreStage(info));
    }
}
