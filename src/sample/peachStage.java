package sample;

import javafx.stage.Stage;
import mayflower.Actor;
import mayflower.World;

public class peachStage extends World{
    enum StageObject{
        WALL,
        SNAKE,
        PEACH
    }
    public SnakeActor snek = new SnakeActor();
    public StageObject[][] peachGrid = new StageObject[40][30];
    final int mulitplier = 20;
    public peachStage()
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
        SnakeActor snek = new SnakeActor();
        addObject(snek, 20, 20);
        addRandomPeach();
    }

    public void updateStage()
    {

    }


    @Override
    public void act() {

    }
    public StageObject[][] getGrid() {
        return peachGrid;
    }
    public boolean addRandomPeach(){
        for(Actor a : getObjects()){
            if(a instanceof Peach){
                return false;
            }
        }
        GridPoint point = Peach.getEmptyRandomSpace(this);
        //IF WE EVER USE A METHOD THAT UPDATES BASED ON GRID then this needs to change
        Peach newPeach = new Peach();
        addObject(newPeach, point.getC()*20, point.getR()*20);//grid[point.getR()][point.getC()] = StageObject.PEACH; //This is the code to change it to
        if(newPeach.isTouching()){
            removeObject(newPeach);
            addRandomPeach();
        }
        return true;
    }

}