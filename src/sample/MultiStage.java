package sample;
import mayflower.*;
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
            //player 2 = tfgh
            addObject(snek2, 740, 540);
            snek2.setUpControl(Keyboard.KEY_T);
            snek2.setDownControl(Keyboard.KEY_G);
            snek2.setLeftControl(Keyboard.KEY_F);
            snek2.setRightControl(Keyboard.KEY_H);
        }
        else if(numPlay == 3)
        {
            addObject(snek2, 740, 540);
            snek2.setUpControl(Keyboard.KEY_T);
            snek2.setDownControl(Keyboard.KEY_G);
            snek2.setLeftControl(Keyboard.KEY_F);
            snek2.setRightControl(Keyboard.KEY_H);

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
            snek2.setUpControl(Keyboard.KEY_T);
            snek2.setDownControl(Keyboard.KEY_G);
            snek2.setLeftControl(Keyboard.KEY_F);
            snek2.setRightControl(Keyboard.KEY_H);

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
}
