package sample;


import mayflower.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class SMStage extends World{
    enum StageObject{
        WALL,
        SNAKE,
        MOUSE
    }
    private SnakeActor snek;
    private StageObject[][] peachGrid = new StageObject[30][40];
    private final int multiplier = 20;
    public SMStage(){
        for(int r = 0; r < 30; r++)
        {
            for(int c = 0; c < 40; c++)
            {
                if(r == 0 || r == 29 || c == 0 || c == 39)
                {
                    peachGrid[r][c] = StageObject.WALL;
                    addObject(new wall(), c* multiplier, r* multiplier);
                }
            }
        }
    }
    public void setSnek(SnakeActor sa){
        removeObject(snek);
        snek = sa;
        addObject(snek, 40, 40);
    }

    public String getHS()
    {
        String score;
        List<String> scoreList = new ArrayList<String>();
        File test = new File("scores.txt");
        Scanner scoreFile = null;
        try {
            scoreFile = new Scanner(test);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int high;

        if(!scoreFile.hasNext())
        {
            return "0";
        }

        while(scoreFile.hasNext())
        {
            score = scoreFile.next();
            System.out.println(score);
            scoreList.add(score);
        }

        System.out.println(scoreList);
        System.out.println(scoreList.get(0));
        int count = 0;
        int index = 0;
        high = Integer.parseInt(scoreList.get(0));
        while(count < scoreList.size())
        {
            int temp = Integer.parseInt(scoreList.get(count));
            if(temp > high)
            {
                index = count;
                high = temp;
            }
            count++;
        }
        File nameFile = new File("names.txt");
        String name = "";
        try(Scanner in = new Scanner(nameFile)){
            if(in.hasNextLine())
                in.nextLine();
            for(int i = 0; i <= index; i++){
                name = in.nextLine();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return name + ": " + high;
    }


    public void updateStage()
    {

    }




    @Override
    public void act() {

    }

    public StageObject[][] getGrid() {
        return peachGrid;
    }



}
