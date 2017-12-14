package sample;

import mayflower.Label;
import mayflower.Mayflower;
import mayflower.World;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.*;

public class highScoreStage extends World{
    private List<Label> labels;
    private List<Label> twitchScores;
    private GameInfo info;
    public highScoreStage(GameInfo info)
    {
        this.info = info;
        labels = new ArrayList<>();
        twitchScores = new ArrayList<>();
        addScores("scores.txt", labels);
        addNames("names.txt", labels);
        addScores("twitch_scores.txt", twitchScores);
        addNames("twitch_names.txt", twitchScores);
        labels.sort(scoreSort);
        labels.add(0, new Label("Single Player:"));
        twitchScores.add(0, new Label("Twitch:"));
        for(int i = 0; i < labels.size(); i++){
            Label l = labels.get(i);
            l.setText(i+1+". "+l.getText());
            if(i < 10)
                addObject(l, 20, i*30);
        }
        for(int i = 0; i < twitchScores.size(); i++){
            Label l = twitchScores.get(i);
            l.setText(i+1+". "+l.getText());
            if(i < 10)
                addObject(l, 120, i*30);
        }

    }
    public void addNames(String fname, List<Label> labels){
        List<String> names = new ArrayList<>();
        File file = new File(fname);
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

    public void addScores(String fname, List<Label> labels){
        String score;
        List<Integer> scoreList = new ArrayList<Integer>();
        File test = new File(fname);
        Scanner scoreFile = null;
        try {
            scoreFile = new Scanner(test);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Mayflower.ask("Are you sure you typed that filename in right?");
            Mayflower.ask("This use of try/catch is a pathway to many errors some consider to be unnatural.");
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
        else
        {
            for(int i = 1; i <= scoreList.size(); i++)
            {
                Label l = new Label(""+scoreList.get(i-1));
                labels.add(l);
            }
        }
        addObject(new MainScreenButton("MainButton.png", info), 625, 500);
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
