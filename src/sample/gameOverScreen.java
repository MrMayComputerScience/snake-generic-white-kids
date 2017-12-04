package sample;

import mayflower.*;

public class gameOverScreen extends World{
    Button paButton = new PlayAgainButton("PlayAgain.png");
    Button mainButton = new MainScreenButton("MainButton.png");
    public gameOverScreen(SnakeActor s, int numPlayers)
    {
        if(numPlayers == 1){
            if(s.getTailLength() < 10){
                showText("you suck", 400, 300);
            }
            else if(s.getTailLength() >= 10 && s.getTailLength() < 25){
                showText("you're okay", 400, 300);
            }
            else if(s.getTailLength() >= 25 && s.getTailLength() < 100){
                showText("you're pretty good", 400, 300);
            }
            else if(s.getTailLength() >= 100){
                showText("you're a god", 400, 300);
            }
            showText("You Lasted " + s.getTime() + " Seconds And Ate " + s.getTailLength() + " Peaches", 50, 100);
            showText("Ratio: " + s.getRatio(),100,150);
            addObject(paButton, 200, 450);
            addObject(mainButton, 400, 450);
        }
        else if(numPlayers <= 4){
            showText("Player " + s.getId() + " has won!", 50, 100);
        }

    }
    @Override
    public void act() {

    }
}
