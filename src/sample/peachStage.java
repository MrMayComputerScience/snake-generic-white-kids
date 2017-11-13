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
    public StageObject[][] peachGrid = new StageObject[30][40];
    private final int mulitplier = 20;
    public peachStage()
    {
        for(int r = 0; r < 30; r++)
        {
            for(int c = 0; c < 40; c++)
            {
                if(r == 0 || r == 29 || c == 0 || c == 39)
                {
                    peachGrid[r][c] = StageObject.WALL;
                    addObject(new wall(), c*mulitplier, r*mulitplier);
                }
            }
        }
        SnakeActor snek = new SnakeActor();
        addObject(snek, 20, 20);
        while(!addRandomPeach()){

        }
    }

    public void updateStage()
    {

    }


    @Override
    public void act() {
        if(getObjects(Peach.class).size() < 1)
            addRandomPeach();
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
        System.out.println("R: "+point.getR()+" C: "+point.getC());
        System.out.println(newPeach.getX()+" "+newPeach.getY());
        if(newPeach.isTouching() || getObjects(Peach.class).size() == 0){
            removeObject(newPeach);
            System.out.println("Replaced");
            addRandomPeach();
        }
        return true;
    }

}