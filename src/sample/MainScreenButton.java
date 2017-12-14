package sample;
import mayflower.*;
public class MainScreenButton extends Button {
    private GameInfo info;
    public MainScreenButton(String name, GameInfo inf){
        super(name);
        info = inf;
    }
    public void OnClick(){
        Mayflower.setWorld(new titleStage(info));
    }
}
