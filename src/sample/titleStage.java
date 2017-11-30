package sample;
import mayflower.*;

public class titleStage extends World{
    Button fpButton = new SinglePlayerButton("StartSinglePlayer.jpg");
    Button lanButton = new LANButton("NotImplemented.png");
<<<<<<< HEAD
    //Button mpButton = new MultiplayerButton("NotImplemented.png");
=======
    Button mpButton = new MultiplayerButton("Multiplayer.png");
>>>>>>> origin/CP
    Button hsButton = new HighScoreButton("HighScoreButton.png");
    public titleStage(){
        setBackground("title.png");
        addObject(fpButton, 25,450);
        addObject(lanButton, 225,450);
        //addObject(mpButton, 425,450);
        addObject(hsButton, 625, 450);
    }
    public void act(){
        //fpButton.OnClick();
    }

}
