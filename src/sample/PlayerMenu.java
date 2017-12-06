package sample;
import mayflower.*;
public class PlayerMenu extends World{

    private PlayerNumberButton two;
    private PlayerNumberButton three;
    private PlayerNumberButton four;
    private BackButton bb;
    public PlayerMenu(){
        showText("Selected Number of Players", 175, 50);

        PlayerNumberButton two = new TwoPlayerButton("TwoPlayer.png", 2);
        addObject(two, 125, 200);

        PlayerNumberButton three = new ThreePlayerButton("ThreePlayer.png", 3);
        addObject(three, 325, 200);

        PlayerNumberButton four = new FourPlayerButton("FourPlayer.png",4);
        addObject(four, 525, 200);

        bb = new BackButton("backbutton.png");
        addObject(bb, 50,500);
    }
    public void act() {

    }
}
