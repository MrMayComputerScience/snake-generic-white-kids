package sample;
import mayflower.*;
public class MainScreenButton extends Button {
    private GameInfo info;
    public MainScreenButton(String name, GameInfo info){
        super(name);
        this.info = info;
    }
    public void OnClick(){
        Mayflower.setWorld(new titleStage(info));
    }
}
