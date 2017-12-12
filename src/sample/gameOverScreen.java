package sample;

import mayflower.*;

public class gameOverScreen extends World{
    Button paButton;
    Button mainButton = new MainScreenButton("MainButton.png");
    public gameOverScreen(SnakeActor s, int numPlayers)
    {
        System.out.println(s.getMyWorld());
        paButton = new PlayAgainButton("PlayAgain.png", s.getMyWorld());
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

        }
        else if(numPlayers <= 4){
            if(s.getId() != MultiStage.NO_WIN)
                showText("Player " + s.getId() + " has won!", 50, 100);
            else{
                showText("You all suck. I do entreat you to feel the", 40, 100);
                showText("burning shame that is more than deserved by", 40, 150);
                showText("your absolutely pitiful performance.", 40, 200);
                showText("Good day, disgraceful sirs.", 40, 300);
            }

        }
        addObject(paButton, 200, 450);
        addObject(mainButton, 400, 450);

    }
    @Override
    public void act() {

    }
}
