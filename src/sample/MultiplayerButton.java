package sample;
import mayflower.*;
public class MultiplayerButton extends Button {
    public MultiplayerButton(String name){
        super(name);
    }
    public void OnClick(){
        Mayflower.setWorld(new PlayerMenu());
    }
}
