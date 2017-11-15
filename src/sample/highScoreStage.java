package sample;

import mayflower.Label;
import mayflower.Mayflower;
import mayflower.World;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class highScoreStage extends World{
    private List<Label> labels;
    public highScoreStage()
    {
        labels = new ArrayList<>();
        addScores();
        addNames();
        labels.sort(scoreSort);
        for(int i = 0; i < labels.size(); i++){
            Label l = labels.get(i);
            l.setText(i+1+". "+l.getText());
            addObject(l, 20, i*25);
        }


    }
    public void addNames(){
        List<String> names = new ArrayList<>();
        File file = new File("names.txt");
        try(Scanner in = new Scanner(file)){
            int count = 0;
            while(in.hasNextLine()){
                String line = in.nextLine();
                if(!line.equals("")){
                    Label l = labels.get(count);
                    l.setText(line + " " + l.getText());
                    count++;
                }

            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void addScores(){
        String score;
        List<Integer> scoreList = new ArrayList<Integer>();
        File test = new File("scores.txt");
        Scanner scoreFile = null;
        try {
            scoreFile = new Scanner(test);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Mayflower.ask("Are you sure you typed that filename in right?");
            Mayflower.ask("Your use of try/catch is a pathway to many errors some consider to be unnatural.");
            Mayflower.ask("Ironic... I could save others from bad coding, but not myself");
        }

        while(scoreFile.hasNext())
        {

            score = scoreFile.next();
            System.out.println(score);
            scoreList.add(Integer.parseInt(score));
        }
        if(scoreList.size() == 0)
        {
            addObject(new Label("No High Scores Yet"), 20, 20);
        }
        else if(scoreList.size() < 10)
        {
            for(int i = 1; i <= scoreList.size(); i++)
            {
                Label l = new Label(""+scoreList.get(i-1));
                addObject(l, 20, i*25);
                labels.add(l);
            }
        }

        else if(scoreList.size() >= 10)
        {
            for(int i = 1; i < 11; i++)
            {
                Label l = new Label(""+scoreList.get(i-1));

                labels.add(l);
            }
        }
        addObject(new MainScreenButton("MainButton.png"), 625, 500);
    }
    private Comparator<Label> scoreSort= new Comparator<Label>() {
        @Override
        public int compare(Label o1, Label o2) {
            String t1 = o1.getText();
            String t2 = o2.getText();
            int i1 = Integer.parseInt(t1.substring(t1.indexOf(' ')+1, t1.length()));
            int i2 = Integer.parseInt(t2.substring(t2.indexOf(' ')+1, t2.length()));
            System.out.println(i1+", "+i2);
            return i2-i1;
        }
    };
    @Override
    public void act() {

    }
}
