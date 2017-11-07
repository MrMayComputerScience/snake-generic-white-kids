package sample;

import mayflower.World;

public class peachStage extends World{
    public peachStage()
    {
        SnakeActor snek = new SnakeActor();
        addObject(snek, 20, 20);
    }

    @Override
    public void act() {

    }
}