package sample;
import mayflower.*;

public class titleStage extends World{
    private GameInfo info;
    Button fpButton;
    Button lanButton;
    //Button mpButton;
    Button mpButton;
    Button hsButton;
    public titleStage(GameInfo inf){
        info = inf;
        Button fpButton = new SinglePlayerButton("StartSinglePlayer.jpg", info);
        Button lanButton = new LANButton("NotImplemented.png");
        //Button mpButton = new MultiplayerButton("NotImplemented.png");
        Button mpButton = new MultiplayerButton("Multiplayer.png", info);
        Button hsButton = new HighScoreButton("HighScoreButton.png", info);

        Button themeButton = new themeMenuButton("theme.png", info);

        setBackground("title.png");
        addObject(fpButton, 25,450);
        addObject(lanButton, 225,450);
        addObject(mpButton, 425,450);
        addObject(hsButton, 625, 450);
        addObject(themeButton, 300,200);
    }
    public void act(){
        //fpButton.OnClick();
    }

}
