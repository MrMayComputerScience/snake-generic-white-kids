package sample;

import javafx.stage.Stage;
import mayflower.World;

public class PeachStage extends World{
    enum StageObject{
        WALL,
        SNAKE,
        PEACH
    }
    public StageObject[][] grid = new StageObject[30][40];
    public PeachStage()
    {
        for(int r = 0; r < 30; r++)
        {
            for(int c = 0; c < 40; c++)
            {
                if(r == 0 || r == 29 || c == 0 || c == 39)
                {
                    grid[r][c] = StageObject.WALL;
                }
            }
        }
        SnakeActor snek = new SnakeActor();
        Peach pech = new Peach();
        addObject(snek, 20, 20);
        addObject(pech, 40,40);
    }

    @Override
    public void act() {

    }
}