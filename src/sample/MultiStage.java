package sample;
import mayflower.*;

import java.util.List;

public class MultiStage extends peachStage{
    public static final int NO_WIN = -42;
    private boolean hasWon;
    private int numPlay = 0;
    private SnakeActor snek2;
    private SnakeActor snek3;
    private SnakeActor snek4;
    private GameInfo info;

    public MultiStage(int numnum, GameInfo info)
    {
        super(info);
        this.info = info;

        hasWon = false;
        setSnek(new SnakeActor(1));
        snek2 = new SnakeActor(2);
        snek3 = new SnakeActor(3);
        snek4 = new SnakeActor(4);
        snek2.setRotation(Direction.WEST);
        numPlay = numnum;
        if(numPlay == 2)
        {
            //player 2 = yghj
            addObject(snek2, 740, 540);
            snek2.setUpControl(Keyboard.KEY_Y);
            snek2.setDownControl(Keyboard.KEY_H);
            snek2.setLeftControl(Keyboard.KEY_G);
            snek2.setRightControl(Keyboard.KEY_J);
        }
        else if(numPlay == 3)
        {
            snek2 = new SnakeActor(2);
            snek3 = new SnakeActor(3);
            addObject(snek2, 740, 540);
            snek2.setUpControl(Keyboard.KEY_Y);
            snek2.setDownControl(Keyboard.KEY_H);
            snek2.setLeftControl(Keyboard.KEY_G);
            snek2.setRightControl(Keyboard.KEY_J);

            //player 3 = pl;'
            addObject(snek3, 740, 40);
            snek3.setUpControl(Keyboard.KEY_P);
            snek3.setDownControl(Keyboard.KEY_SEMICOLON);
            snek3.setLeftControl(Keyboard.KEY_L);
            snek3.setRightControl(Keyboard.KEY_APOSTROPHE);
        }
        else if(numPlay == 4)
        {
            snek2 = new SnakeActor(2);
            snek3 = new SnakeActor(3);
            snek4 = new SnakeActor(4);
            addObject(snek2, 740, 540);
            snek2.setUpControl(Keyboard.KEY_Y);
            snek2.setDownControl(Keyboard.KEY_H);
            snek2.setLeftControl(Keyboard.KEY_G);
            snek2.setRightControl(Keyboard.KEY_J);

            addObject(snek3, 740, 40);
            snek3.setUpControl(Keyboard.KEY_P);
            snek3.setDownControl(Keyboard.KEY_SEMICOLON);
            snek3.setLeftControl(Keyboard.KEY_L);
            snek3.setRightControl(Keyboard.KEY_APOSTROPHE);

            //player 4 = arrows
            addObject(snek4, 40, 540);
            snek4.setUpControl(Keyboard.KEY_UP);
            snek4.setDownControl(Keyboard.KEY_DOWN);
            snek4.setLeftControl(Keyboard.KEY_LEFT);
            snek4.setRightControl(Keyboard.KEY_RIGHT);
        }
    }
    @Override
    public void act() {
        super.act();
        if (numPlay == 2 && (!super.getSnek().getRunning() || !snek2.getRunning())) {
            if (snek2.isPressing() && super.getSnek().isPressing()) {
                super.getSnek().startTimer();
                snek2.startTimer();
            }
        } else if (numPlay == 3 && (!super.getSnek().getRunning() || !snek2.getRunning() || !snek3.getRunning())) {
            if (super.getSnek().isPressing() && snek2.isPressing() && snek3.isPressing()) {
                super.getSnek().startTimer();
                snek2.startTimer();
                snek3.startTimer();
            }
        } else if (numPlay == 4 && (!super.getSnek().getRunning() || !snek2.getRunning() || !snek3.getRunning() || !snek4.getRunning())) {
            if (super.getSnek().isPressing() && snek2.isPressing() && snek3.isPressing() && snek4.isPressing()) {
                super.getSnek().startTimer();
                snek2.startTimer();
                snek3.startTimer();
                snek4.startTimer();
            }
        }
    }

    @Override
    protected void detectWin(){
        List<SnakeActor> sneks = getObjects(SnakeActor.class);
        if(hasWon){
            if(sneks.size() == 0){
                Mayflower.setWorld(new gameOverScreen(new SnakeActor(NO_WIN).setWorld(this), numPlay, info));
            }
            else
                Mayflower.setWorld(new gameOverScreen(sneks.get(0), numPlay, info));
        }

        if(sneks.size() <= 1)
            hasWon = true;

    }

    public int getNumPlayers(){
        return numPlay;
    }
}
