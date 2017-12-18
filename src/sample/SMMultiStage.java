package sample;
import mayflower.*;

import java.util.List;

public class SMMultiStage extends SMStage {
    public static final int NO_WIN = -42;
    private boolean hasWon;

    private SvMSnakeActor snek;
    private MouseActor ms1;
    private MouseActor ms2;
    private MouseActor ms3;
    private MouseActor ms4;
    private int upControl;
    private int downControl;
    private int leftControl;
    private int rightControl;
    private int rand;
    private int wins1;
    private int wins2;
    private int wins3;
    private int wins4;
    private List<MouseActor> mice;
    private GameInfo info;
    public SMMultiStage(GameInfo info) {
        super();
        this.info = info;
        hasWon = false;
        //rand = 1 + (int) (Math.random() * 4);
        rand = 3;
        wins1 = 0;
        wins2 = 0;
        wins3 = 0;
        wins4 = 0;
        System.out.println(rand);


        if (rand == 1) {
            snek = new SvMSnakeActor(1);
            setSnek(snek, 1);
            snek.setControls(Keyboard.KEY_W, Keyboard.KEY_S, Keyboard.KEY_A, Keyboard.KEY_D);
            ms2 = new MouseActor(2);
            ms3 = new MouseActor(3);
            ms4 = new MouseActor(4);
            //addObject(getSnek(), 40, 40);
            addObject(ms2, 740, 540);
            ms2.setUpControl(Keyboard.KEY_Y);
            ms2.setDownControl(Keyboard.KEY_H);
            ms2.setLeftControl(Keyboard.KEY_G);
            ms2.setRightControl(Keyboard.KEY_J);

            addObject(ms3, 740, 40);
            ms3.setUpControl(Keyboard.KEY_P);
            ms3.setDownControl(Keyboard.KEY_SEMICOLON);
            ms3.setLeftControl(Keyboard.KEY_L);
            ms3.setRightControl(Keyboard.KEY_APOSTROPHE);

            //player 4 = arrows
            addObject(ms4, 40, 540);
            ms4.setUpControl(Keyboard.KEY_UP);
            ms4.setDownControl(Keyboard.KEY_DOWN);
            ms4.setLeftControl(Keyboard.KEY_LEFT);
            ms4.setRightControl(Keyboard.KEY_RIGHT);
        } else if (rand == 2) {
            snek = new SvMSnakeActor(2);
            setSnek(snek, 2);
            snek.setControls(Keyboard.KEY_Y, Keyboard.KEY_H, Keyboard.KEY_G, Keyboard.KEY_J);
            ms1 = new MouseActor(1);
            ms3 = new MouseActor(3);
            ms4 = new MouseActor(4);
            //addObject(getSnek(), 740, 540);
            addObject(ms1, 40, 40);
            ms1.setControls(Keyboard.KEY_W, Keyboard.KEY_S, Keyboard.KEY_A, Keyboard.KEY_D);
            ms3.setControls(Keyboard.KEY_P, Keyboard.KEY_SEMICOLON, Keyboard.KEY_L, Keyboard.KEY_APOSTROPHE);
            addObject(ms3, 740, 40);
            ms4.setControls(Keyboard.KEY_UP, Keyboard.KEY_DOWN, Keyboard.KEY_LEFT, Keyboard.KEY_RIGHT);
            addObject(ms4, 40, 540);

        } else if (rand == 3) {
            snek = new SvMSnakeActor(3);
            setSnek(snek, 3);

            ms1 = new MouseActor(1);
            ms2 = new MouseActor(2);
            ms4 = new MouseActor(4);
            ms2.setControls(Keyboard.KEY_Y, Keyboard.KEY_H, Keyboard.KEY_G, Keyboard.KEY_J);
            addObject(getSnek(), 740, 40);
            addObject(ms1, 40, 40);
            ms1.setControls(Keyboard.KEY_W, Keyboard.KEY_S, Keyboard.KEY_A, Keyboard.KEY_D);
            snek.setControls(Keyboard.KEY_P, Keyboard.KEY_SEMICOLON, Keyboard.KEY_L, Keyboard.KEY_APOSTROPHE);
            addObject(ms2, 740, 540);
            ms4.setControls(Keyboard.KEY_UP, Keyboard.KEY_DOWN, Keyboard.KEY_LEFT, Keyboard.KEY_RIGHT);
            addObject(ms4, 40, 540);
        } else if (rand == 4) {
            snek = new SvMSnakeActor(4);
            setSnek(snek, 4);

            ms1 = new MouseActor(1);
            ms3 = new MouseActor(3);
            ms2 = new MouseActor(2);
            ms2.setControls(Keyboard.KEY_Y, Keyboard.KEY_H, Keyboard.KEY_G, Keyboard.KEY_J);
            addObject(ms3, 740, 40);
            addObject(ms1, 40, 40);
            ms1.setControls(Keyboard.KEY_W, Keyboard.KEY_S, Keyboard.KEY_A, Keyboard.KEY_D);
            ms3.setControls(Keyboard.KEY_P, Keyboard.KEY_SEMICOLON, Keyboard.KEY_L, Keyboard.KEY_APOSTROPHE);
            addObject(ms2, 740, 540);
            snek.setControls(Keyboard.KEY_UP, Keyboard.KEY_DOWN, Keyboard.KEY_LEFT, Keyboard.KEY_RIGHT);
            addObject(snek, 40, 540);
        }
    }



    public SMMultiStage(int winner) {
        super();

        System.out.println("player 1 wins: " + wins1);
        System.out.println("player 2 wins: " + wins2);
        System.out.println("player 3 wins: " + wins3);
        System.out.println("player 4 wins: " + wins4);

        //hasWon = false;
        rand = winner;
        System.out.println(rand);
        if (rand == 1) {
            snek = new SvMSnakeActor(1);
            setSnek(snek, 1);
            snek.setControls(Keyboard.KEY_W, Keyboard.KEY_S, Keyboard.KEY_A, Keyboard.KEY_D);
            ms2 = new MouseActor(2);
            ms3 = new MouseActor(3);
            ms4 = new MouseActor(4);
            addObject(getSnek(), 40, 40);
            addObject(ms2, 740, 540);
            ms2.setUpControl(Keyboard.KEY_Y);
            ms2.setDownControl(Keyboard.KEY_H);
            ms2.setLeftControl(Keyboard.KEY_G);
            ms2.setRightControl(Keyboard.KEY_J);

            addObject(ms3, 740, 40);
            ms3.setUpControl(Keyboard.KEY_P);
            ms3.setDownControl(Keyboard.KEY_SEMICOLON);
            ms3.setLeftControl(Keyboard.KEY_L);
            ms3.setRightControl(Keyboard.KEY_APOSTROPHE);

            //player 4 = arrows
            addObject(ms4, 40, 540);
            ms4.setUpControl(Keyboard.KEY_UP);
            ms4.setDownControl(Keyboard.KEY_DOWN);
            ms4.setLeftControl(Keyboard.KEY_LEFT);
            ms4.setRightControl(Keyboard.KEY_RIGHT);
        } else if (rand == 2) {
            snek = new SvMSnakeActor(2);
            setSnek(snek, 2);
            snek.setControls(Keyboard.KEY_Y, Keyboard.KEY_H, Keyboard.KEY_G, Keyboard.KEY_J);
            ms1 = new MouseActor(1);
            ms3 = new MouseActor(3);
            ms4 = new MouseActor(4);
            addObject(getSnek(), 740, 540);
            addObject(ms1, 40, 40);
            ms1.setControls(Keyboard.KEY_W, Keyboard.KEY_S, Keyboard.KEY_A, Keyboard.KEY_D);
            ms3.setControls(Keyboard.KEY_P, Keyboard.KEY_SEMICOLON, Keyboard.KEY_L, Keyboard.KEY_APOSTROPHE);
            addObject(ms3, 740, 40);
            ms4.setControls(Keyboard.KEY_UP, Keyboard.KEY_DOWN, Keyboard.KEY_LEFT, Keyboard.KEY_RIGHT);
            addObject(ms4, 40, 540);

        } else if (rand == 3) {
            snek = new SvMSnakeActor(3);
            setSnek(snek, 3);

            ms1 = new MouseActor(1);
            ms2 = new MouseActor(2);
            ms4 = new MouseActor(4);
            ms2.setControls(Keyboard.KEY_Y, Keyboard.KEY_H, Keyboard.KEY_G, Keyboard.KEY_J);
            addObject(getSnek(), 740, 40);
            addObject(ms1, 40, 40);
            ms1.setControls(Keyboard.KEY_W, Keyboard.KEY_S, Keyboard.KEY_A, Keyboard.KEY_D);
            snek.setControls(Keyboard.KEY_P, Keyboard.KEY_SEMICOLON, Keyboard.KEY_L, Keyboard.KEY_APOSTROPHE);
            addObject(ms2, 740, 540);
            ms4.setControls(Keyboard.KEY_UP, Keyboard.KEY_DOWN, Keyboard.KEY_LEFT, Keyboard.KEY_RIGHT);
            addObject(ms4, 40, 540);
        } else if (rand == 4) {
            snek = new SvMSnakeActor(4);
            setSnek(snek, 4);

            ms1 = new MouseActor(1);
            ms3 = new MouseActor(3);
            ms2 = new MouseActor(2);
            ms2.setControls(Keyboard.KEY_Y, Keyboard.KEY_H, Keyboard.KEY_G, Keyboard.KEY_J);
            addObject(ms3, 740, 40);
            addObject(ms1, 40, 40);
            ms1.setControls(Keyboard.KEY_W, Keyboard.KEY_S, Keyboard.KEY_A, Keyboard.KEY_D);
            ms3.setControls(Keyboard.KEY_P, Keyboard.KEY_SEMICOLON, Keyboard.KEY_L, Keyboard.KEY_APOSTROPHE);
            addObject(ms2, 740, 540);
            snek.setControls(Keyboard.KEY_UP, Keyboard.KEY_DOWN, Keyboard.KEY_LEFT, Keyboard.KEY_RIGHT);
            addObject(snek, 40, 540);
        }
    }
    public void addWin(int id){
        id++;
    }

    @Override
    public void act() {
        super.act();
        mice = getObjects(MouseActor.class);
        if (rand == 1) {
            if ((!super.getSnek().getRunning() || !ms2.getRunning() || !ms3.getRunning() || !ms4.getRunning())) {
                if (super.getSnek().isPressing() && ms2.isPressing() && ms3.isPressing() && ms4.isPressing()) {
                    super.getSnek().startTimer();
                    ms2.startTimer();
                    ms3.startTimer();
                    ms4.startTimer();
                }
            }
        } else if (rand == 2) {
            if ((!super.getSnek().getRunning() || !ms1.getRunning() || !ms3.getRunning() || !ms4.getRunning())) {
                if (super.getSnek().isPressing() && ms1.isPressing() && ms3.isPressing() && ms4.isPressing()) {
                    super.getSnek().startTimer();
                    ms1.startTimer();
                    ms3.startTimer();
                    ms4.startTimer();
                }
            }
        } else if (rand == 3) {
            if ((!super.getSnek().getRunning() || !ms2.getRunning() || !ms1.getRunning() || !ms4.getRunning())) {
                if (super.getSnek().isPressing() && ms2.isPressing() && ms1.isPressing() && ms4.isPressing()) {
                    super.getSnek().startTimer();
                    ms2.startTimer();
                    ms1.startTimer();
                    ms4.startTimer();
                }
            }

        } else if (rand == 4) {
            if ((!super.getSnek().getRunning() || !ms2.getRunning() || !ms3.getRunning() || !ms1.getRunning())) {
                if (super.getSnek().isPressing() && ms2.isPressing() && ms3.isPressing() && ms1.isPressing()) {
                    super.getSnek().startTimer();
                    ms2.startTimer();
                    ms3.startTimer();
                    ms1.startTimer();
                }
            }


        }
        if(mice.size() == 1){

            if(mice.get(0).getId()==1) addWin(wins1);
            else if(mice.get(0).getId()==2)addWin(wins2);
            else if(mice.get(0).getId()==3)addWin(wins3);
            else if(mice.get(0).getId()==4)addWin(wins4);
            Mayflower.setWorld(new SMMultiStage(mice.get(0).getId()));
        }
        detectWin();

    }


    protected void detectWin() {

        if (hasWon) {


             if(wins1 == 3 || wins2 == 3 || wins3 == 3 || wins4 == 3){
                 hasWon = true;
                 Mayflower.setWorld(new ModeMenu(4, info));
             }



        }
    }
}
