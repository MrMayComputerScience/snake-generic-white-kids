package sample;

import mayflower.World;

public class PeachStage extends World{
    enum StageObject{
        WALL,
        SNAKE,
        PEACH
    }
    public StageObject[][] peachGrid = new StageObject[30][40];
    final int mulitplier = 20;
    public PeachStage()
    {
        for(int r = 0; r < 30; r++)
        {
            for(int c = 0; c < 40; c++)
            {
                if(r == 0 || r == 29 || c == 0 || c == 39)
                {
                    peachGrid[r][c] = StageObject.WALL;
                    addObject(new wall(), r*mulitplier, c*mulitplier);
                }
            }
        }
        peachGrid[1][1] = StageObject.SNAKE;
        addObject(new SnakeActor(), mulitplier, mulitplier);
    }

    public void updateStage()
    {

    }


    @Override
    public void act() {

    }
}