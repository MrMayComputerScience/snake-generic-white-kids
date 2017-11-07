package sample;

import mayflower.World;

public class PeachStage extends World{
    public PeachStage()
    {
        SnakeActor snek = new SnakeActor();
        addObject(snek, 20, 20);
    }

    @Override
    public void act() {

    }
}