package sample;

import javafx.stage.Stage;
import mayflower.Actor;
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
        addObject(snek, 20, 20);
        addRandomPeach();
    }

    @Override
    public void act() {

    }
    public StageObject[][] getGrid() {
        return grid;
    }
    public boolean addRandomPeach(){
        for(Actor a : getObjects()){
            if(a instanceof Peach){
                return false;
            }
        }
        GridPoint point = Peach.getEmptyRandomSpace(this);
        //IF WE EVER USE A METHOD THAT UPDATES BASED ON GRID then this needs to change
        addObject(new Peach(), point.getC()*20, point.getR()*20); //grid[point.getR()][point.getC()] = StageObject.PEACH; //This is the code to change it to
        return true;
    }

}