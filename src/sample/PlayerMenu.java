package sample;
import mayflower.*;
public class PlayerMenu extends World{

    private PlayerNumberButton two;
    private PlayerNumberButton three;
    private PlayerNumberButton four;
    public PlayerMenu(){
        showText("Selected Number of Players", 175, 50);

        PlayerNumberButton two = new TwoPlayerButton("TwoPlayer.png", 2);
        addObject(two, 125, 350);

        PlayerNumberButton three = new ThreePlayerButton("ThreePlayer.png", 3);
        addObject(three, 325, 350);

        PlayerNumberButton four = new FourPlayerButton("FourPlayer.png",4);
        addObject(four, 525, 350);
    }
    public void act() {

    }
}
