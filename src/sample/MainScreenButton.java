package sample;
import mayflower.*;
public class MainScreenButton extends Button {
    public MainScreenButton(String name){
        super(name);
    }
    public void OnClick(){
        Mayflower.setWorld(new titleStage());
    }
}
