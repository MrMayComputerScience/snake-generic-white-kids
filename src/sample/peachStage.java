package sample;

import javafx.stage.Stage;
import mayflower.Actor;

import mayflower.*;
import javafx.stage.Stage;
import mayflower.Actor;
import mayflower.Timer;
import mayflower.World;
import mayflower.Label;
import mayflower.World;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javafx.stage.Stage;
import mayflower.Actor;
import mayflower.Timer;
import mayflower.World;

public class peachStage extends World{
    enum StageObject{
        WALL,
        SNAKE,
        PEACH
    }

    private SnakeActor snek;
    private StageObject[][] peachGrid = new StageObject[30][40];
    private Label playerScore;
    private Timer t;
    private KeyDisplay wd;
    private final int mulitplier = 20;
    public peachStage()
    {
    //    setBackground("background.png");
        snek = new SnakeActor();
        Label scoreLabel = new Label("Highscore: " + getHS());
        playerScore = new Label("Your Score: "+ snek.getTailLength());
        wd = new WDisplay("W.png",Keyboard.KEY_W);
        for(int r = 0; r < 30; r++)
        {
            for(int c = 0; c < 40; c++)
            {
                if(r == 0 || r == 29 || c == 0 || c == 39)
                {
                    peachGrid[r][c] = StageObject.WALL;
                    addObject(new wall(), c*mulitplier, r*mulitplier);
                }
            }
        }
        snek.setUpControl(Keyboard.KEY_W);
        snek.setDownControl(Keyboard.KEY_S);
        snek.setLeftControl(Keyboard.KEY_A);
        snek.setRightControl(Keyboard.KEY_D);
        addObject(wd, 700, 100);
        addObject(snek, 40, 40);
        addObject(scoreLabel, 0,0);
        addObject(playerScore, 550,0);
        t = new Timer(75);
        peachGrid[1][1] = StageObject.SNAKE;
        while(!addRandomPeach()){

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
        if(getObjects(Peach.class).size() < 1)
            addRandomPeach();
    }

    public StageObject[][] getGrid() {
        return peachGrid;
    }

    public boolean addRandomPeach(){
        playerScore.setText("Your Score: "+snek.getTailLength());
        for(Actor a : getObjects()){
            if(a instanceof Peach){
                return false;
            }
        }
        GridPoint point = Peach.getEmptyRandomSpace(this);
        //IF WE EVER USE A METHOD THAT UPDATES BASED ON GRID then this needs to change
        Peach newPeach = new Peach();
        addObject(newPeach, point.getC()*20, point.getR()*20);//grid[point.getR()][point.getC()] = StageObject.PEACH; //This is the code to change it to
        System.out.println("R: "+point.getR()+" C: "+point.getC());
        System.out.println(newPeach.getX()+" "+newPeach.getY());
        if(newPeach.isTouching() || getObjects(Peach.class).size() == 0){
            removeObject(newPeach);
            System.out.println("Replaced");
            addRandomPeach();
        }
        return true;
    }

}