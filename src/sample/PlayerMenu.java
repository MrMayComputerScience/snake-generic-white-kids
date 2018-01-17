package sample;
import mayflower.*;
public class PlayerMenu extends World{

    private PlayerNumberButton two;
    private PlayerNumberButton three;
    private PlayerNumberButton four;
    private BackButton bb;
    private GameInfo info;
    public PlayerMenu(GameInfo info){

        this.info = info;

        showText("Selected Number of Players", 175, 50);

        PlayerNumberButton two = new TwoPlayerButton("TwoPlayer.png", 2, info);
        addObject(two, 125, 200);

        PlayerNumberButton three = new ThreePlayerButton("ThreePlayer.png", 3, info);
        addObject(three, 325, 200);

        PlayerNumberButton four = new FourPlayerButton("FourPlayer.png",4, info);
        addObject(four, 525, 200);

        bb = new BackButton("backbutton.png", info);
        addObject(bb, 50,500);
    }
    public void act() {

    }
}
