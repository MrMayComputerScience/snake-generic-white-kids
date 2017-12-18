package sample;

import mayflower.Actor;

import mayflower.*;
import mayflower.Timer;
import mayflower.World;
import mayflower.Label;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    private KeyDisplay ad;
    private KeyDisplay sd;
    private KeyDisplay dd;

    private KeyDisplay yd;
    private KeyDisplay gd;
    private KeyDisplay hd;
    private KeyDisplay jd;

    private KeyDisplay pd;
    private KeyDisplay ld;
    private KeyDisplay semid;
    private KeyDisplay aposd;

    private KeyDisplay upd;
    private KeyDisplay leftd;
    private KeyDisplay downd;
    private KeyDisplay rightd;
    private final int multiplier = 20;
    private GameInfo info;
    public peachStage(GameInfo info)
    {
    //    setBackground("background.png");
        this.info = info;
        snek = new SnakeActor(1, info);
        Label scoreLabel = new Label("Highscore: " + getHS());

        playerScore = new Label("Your Score: "+ snek.getTailLength());
        wd = new WDisplay("W.png",Keyboard.KEY_W);
        ad = new ADisplay("A.png", Keyboard.KEY_A);
        sd = new SDisplay("S.png", Keyboard.KEY_S);
        dd = new DDisplay("D.png", Keyboard.KEY_D);

        yd = new YDisplay("Y.png",Keyboard.KEY_Y);
        gd = new GDisplay("G.png", Keyboard.KEY_G);
        hd = new HDisplay("H.png", Keyboard.KEY_H);
        jd = new JDisplay("J.png", Keyboard.KEY_J);

        pd = new PDisplay("P.png",Keyboard.KEY_P);
        ld = new LDisplay("L.png", Keyboard.KEY_L);
        semid = new SemiDisplay("semicolon.png", Keyboard.KEY_SEMICOLON);
        aposd = new AposDisplay("apostrophe.png", Keyboard.KEY_APOSTROPHE);

        upd = new UpDisplay("up.png",Keyboard.KEY_UP);
        leftd = new LeftDisplay("left.png", Keyboard.KEY_LEFT);
        downd = new DownDisplay("down.png", Keyboard.KEY_DOWN);
        rightd = new RightDisplay("right.png", Keyboard.KEY_RIGHT);
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
        snek.setUpControl(Keyboard.KEY_W);
        snek.setDownControl(Keyboard.KEY_S);
        snek.setLeftControl(Keyboard.KEY_A);
        snek.setRightControl(Keyboard.KEY_D);

        addObject(wd, 300, 50);
        addObject(ad,275,75);
        addObject(sd,300,75);
        addObject(dd,325,75);

        addObject(yd, 400, 50);
        addObject(gd,375,75);
        addObject(hd,400,75);
        addObject(jd,425,75);

        addObject(pd, 500, 50);
        addObject(ld,475,75);
        addObject(semid,500,75);
        addObject(aposd,525,75);

        addObject(upd, 600, 50);
        addObject(leftd,575,75);
        addObject(downd,600,75);
        addObject(rightd,625,75);

        addObject(snek, 40, 40);
        addObject(scoreLabel, 0,0);
        addObject(playerScore, 550,0);

        t = new Timer(75);


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
        File test = new File(snek instanceof TwitchSnakeActor ?
                "twitch_scores.txt" : "scores.txt");
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
        File nameFile = new File(snek instanceof TwitchSnakeActor ?
                "twitch_names.txt" : "names.txt");
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

    protected void detectWin(){
        if(getObjects(SnakeActor.class).size() == 0)
            if(snek instanceof TwitchSnakeActor){
            TwitchSnakeActor s = (TwitchSnakeActor)snek;
                Mayflower.setWorld(new InitialsInput(s, s.getNumPlayers(), info));
            }
            else
                Mayflower.setWorld(new InitialsInput(snek, 1, info));

    }

    @Override
    public void act() {
        if(!snek.getRunning()){
            if(snek.isPressing())
                snek.startTimer();
        }
        if(getObjects(Peach.class).size() < 1)
            addRandomPeach();
        addPortals();
        detectWin();
    }
    void addPortals(){
        if(info.hasPortals() && getObjects(Portal.class).size() == 0){
            Portal p = new Portal();
            addObject(p, 1,1);
            p.setRandomLocation();
            while(p.isTouching())
                p.setRandomLocation();
            p.createPair(1,1);
            p.getPair().setRandomLocation();
            while(p.getPair().isTouching())
                p.getPair().setRandomLocation();
        }
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
        Peach newPeach = new Peach(info.getGameTheme());
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

    public SnakeActor getSnek() {
        return snek;
    }
}