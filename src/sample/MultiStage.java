package sample;
import mayflower.*;

import java.util.List;

public class MultiStage extends peachStage{
    private int numPlay = 0;
    private SnakeActor snek2;
    private SnakeActor snek3;
    private SnakeActor snek4;

    public MultiStage(int numnum)
    {
        super();
        snek2 = new SnakeActor(2);
        snek3 = new SnakeActor(3);
        snek4 = new SnakeActor(4);
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
    protected void detectWin(){
        List<SnakeActor> sneks = getObjects(SnakeActor.class);
        if(sneks.size() == 1)
            Mayflower.setWorld(new gameOverScreen(sneks.get(0), numPlay));
    }
}
