package sample;
import mayflower.*;
public class PlayAgainButton extends Button {
    public World prevGame;
    public PlayAgainButton(String name, World previousGame){
        super(name);
        prevGame = previousGame;
    }
    public void OnClick(){

        try {
            Mayflower.setWorld(prevGame.getClass().getDeclaredConstructor().newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
