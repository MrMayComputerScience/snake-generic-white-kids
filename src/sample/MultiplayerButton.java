package sample;
import mayflower.*;
public class MultiplayerButton extends Button {
    private GameInfo info;
    public MultiplayerButton(String name, GameInfo info){
        super(name);
        this.info = info;
    }
    public void OnClick(){
        Mayflower.setWorld(new PlayerMenu(info));
    }
}
