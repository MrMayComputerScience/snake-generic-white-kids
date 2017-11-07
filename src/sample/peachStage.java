package sample;

import mayflower.World;

public class PeachStage extends World{
    enum StageObject{
        WALL,
        SNAKE,
        PEACH
    }
    public PeachStage()
    {
        SnakeActor snek = new SnakeActor();
        Peach pech = new Peach();
        addObject(snek, 20, 20);
        addObject(pech, 40,40);
    }

    @Override
    public void act() {

    }
}