package sample;

import mayflower.Label;
import mayflower.World;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class highScoreStage extends World{

    public highScoreStage()
    {


        String score;
        List<Integer> scoreList = new ArrayList<Integer>();
        File test = new File("scores.txt");
        Scanner scoreFile = null;
        try {
            scoreFile = new Scanner(test);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while(scoreFile.hasNext())
        {

            score = scoreFile.next();
            System.out.println(score);
            scoreList.add(Integer.parseInt(score));
        }
        Collections.sort(scoreList, Collections.reverseOrder());
        if(scoreList.size() == 0)
        {
            addObject(new Label("No High Scores Yet"), 20, 20);
        }
        else if(scoreList.size() < 10)
        {
            for(int i = 1; i < scoreList.size(); i++)
            {
                addObject(new Label(i + ". " + scoreList.get(i-1)), 20, i*20);
            }
        }

        else if(scoreList.size() >= 10)
        {
            for(int i = 1; i < 11; i++)
            {
                addObject(new Label(i + ". " + scoreList.get(i-1)), 20, i*25);
            }
        }
        addObject(new MainScreenButton("MainButton.png"), 625, 500);
    }

    @Override
    public void act() {

    }
}
