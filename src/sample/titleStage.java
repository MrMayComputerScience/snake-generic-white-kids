package sample;
import mayflower.*;

public class titleStage extends World{
    private GameInfo info;
    Button fpButton;
    Button lanButton;
    //Button mpButton;
    Button mpButton;
    Button hsButton;
    public titleStage(GameInfo info){
        this.info = info;
        fpButton = new SinglePlayerButton("StartSinglePlayer.jpg", info);
        lanButton = new LANButton("NotImplemented.png");
        //mpButton = new MultiplayerButton("NotImplemented.png");
        mpButton = new MultiplayerButton("Multiplayer.png", info);
        hsButton = new HighScoreButton("HighScoreButton.png", info);
        setBackground("title.png");
        addObject(fpButton, 25,450);
        addObject(lanButton, 225,450);
        addObject(mpButton, 425,450);
        addObject(hsButton, 625, 450);
    }
    public void act(){
        //fpButton.OnClick();
    }

}
