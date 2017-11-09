package sample;

import mayflower.World;

public class PeachStage extends World{
    enum StageObject{
        WALL,
        SNAKE,
        PEACH
    }
    public StageObject[][] peachGrid = new StageObject[40][30];
    final int mulitplier = 20;
    public PeachStage()
    {
        for(int r = 0; r < 40; r++)
        {
            for(int c = 0; c < 30; c++)
            {
                if(r == 0 || r == 39 || c == 0 || c == 29)
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