package sample;
import mayflower.*;
public class PlayAgainButton extends Button {
    public PlayAgainButton(String name){
        super(name);
    }
    public void OnClick(){
        Mayflower.setWorld(new peachStage());
    }

}
