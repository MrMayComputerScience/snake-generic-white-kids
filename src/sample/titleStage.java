package sample;
import mayflower.*;

import javax.swing.*;

public class titleStage extends World{
    Button fpButton = new SinglePlayerButton("StartSinglePlayer.jpg");
    Button LButton = new LANButton("NotImplemented.png");
    Button LButton2 = new LANButton("NotImplemented.png");
    public titleStage(){
        setBackground("title.png");
        addObject(fpButton, 100,450);
        addObject(LButton, 300,450);
        addObject(LButton2, 500,450);
    }
    public void act(){
        //fpButton.OnClick();
    }

}
