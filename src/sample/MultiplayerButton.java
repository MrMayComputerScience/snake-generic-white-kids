package sample;
import mayflower.*;
public class MultiplayerButton extends Button {
    private GameInfo info;
    public MultiplayerButton(String name, GameInfo inf){
        super(name);
        info = inf;
    }
    public void OnClick(){
        Mayflower.setWorld(new PlayerMenu(info));
    }
}
