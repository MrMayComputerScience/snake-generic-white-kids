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
    private Label pos1;
    private Label pos2;
    private Label pos3;
    private Label pos4;

    public MultiStage(int numnum, GameInfo info)
    {
        super(info);
        pos1 = new Label("1", 24);
        pos2 = new Label("2", 24);
        pos3 = new Label("3", 24);
        pos4 = new Label("4", 24);
        addObject(pos1, 20, 40);
        System.out.println("MultiStage Constructor");
        this.info = info;
        info.setNumPlayers(numnum);
        hasWon = false;
        setSnek(new SnakeActor(1, info));
        snek2 = new SnakeActor(2, info);
        snek3 = new SnakeActor(3, info);
        snek4 = new SnakeActor(4,info);
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
            addObject(pos2, 760, 560);
        }
        else if(numPlay == 3)
        {
            snek2 = new SnakeActor(2, info);
            snek3 = new SnakeActor(3, info);
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
            addObject(pos2, 760, 560);
            addObject(pos3, 760, 40);
        }
        else if(numPlay == 4)
        {
            snek2 = new SnakeActor(2, info);
            snek3 = new SnakeActor(3, info);
            snek4 = new SnakeActor(4, info);
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
            addObject(pos2, 760, 560);
            addObject(pos3, 760, 40);
            addObject(pos4, 20,560);
        }
    }
    @Override
    public void act() {
        System.out.println("Stage: "+this);
        if(!hasWon){
            super.act();
            activateTron();
            startGame();
        }
    }
    @Override
    void startGame(){
        if (numPlay == 2 && (!super.getSnek().getRunning() || !snek2.getRunning())) {
            if (snek2.isPressing() && super.getSnek().isPressing()) {
                super.getSnek().startTimer();
                snek2.startTimer();
                removeObject(pos1);
                removeObject(pos2);
            }
        } else if (numPlay == 3 && (!super.getSnek().getRunning() || !snek2.getRunning() || !snek3.getRunning())) {
            if (super.getSnek().isPressing() && snek2.isPressing() && snek3.isPressing()) {
                super.getSnek().startTimer();
                snek2.startTimer();
                snek3.startTimer();
                removeObject(pos1);
                removeObject(pos2);
                removeObject(pos3);
            }
        } else if (numPlay == 4 && (!super.getSnek().getRunning() || !snek2.getRunning() || !snek3.getRunning() || !snek4.getRunning())) {
            if (super.getSnek().isPressing() && snek2.isPressing() && snek3.isPressing() && snek4.isPressing()) {
                super.getSnek().startTimer();
                snek2.startTimer();
                snek3.startTimer();
                snek4.startTimer();
                removeObject(pos1);
                removeObject(pos2);
                removeObject(pos3);
                removeObject(pos4);
            }
        }
    }
    private void activateTron(){
        if(info.isTron() && !getSnek().getTronMode()){
            getSnek().setTronMode(true);
            snek2.setTronMode(true);
            snek3.setTronMode(true);
            snek4.setTronMode(true);
        }
        if(info.isTron())
            for(Peach p : getObjects(Peach.class)){
                removeObject(p);
            }
    }
    @Override
    protected void detectWin(){
        if(!hasWon){
            List<SnakeActor> sneks = getObjects(SnakeActor.class);
            if(sneks.size() == 0){
                Mayflower.setWorld(new gameOverScreen(new SnakeActor(NO_WIN, info).setWorld(this), numPlay, info));
                hasWon = true;
            }
            else if(sneks.size() <= 1){
                Mayflower.setWorld(new gameOverScreen(sneks.get(0), numPlay, info));
                hasWon = true;
            }
        }


    }





    public int getNumPlayers(){
        return numPlay;
    }
}
