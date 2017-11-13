package sample;

import mayflower.World;

public class gameOverScreen extends World{
    Button paButton = new PlayAgainButton("PlayAgain.png");
    Button mainButton = new MainScreenButton("MainButton.png");
    public gameOverScreen()
    {
        showText("you suck", 400, 300);

        addObject(paButton, 200, 450);
        addObject(mainButton, 400, 450);
    }

    @Override
    public void act() {

    }
}
