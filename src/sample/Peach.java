package sample;

import mayflower.Actor;

import java.util.LinkedList;
import java.util.List;

public class Peach extends Actor{
    private int x;
    private int y;

    public Peach(){
        setImage("peach.png");
    }
    public static GridPoint getEmptyRandomSpace(peachStage stage){
        List<GridPoint> empty = new LinkedList<>();
        for(int r = 0; r < stage.getGrid().length; r++){
            for(int c = 0; c < stage.getGrid()[r].length; c++){
                if(stage.getGrid()[r][c] == null){
                    empty.add(new GridPoint(r,c));
                }
            }
        }
        int index = (int)(Math.random()*empty.size());
        return empty.get(index);
    }
    public static void addRandomPeach(peachStage world){
        world.addRandomPeach();
    }
    public boolean isTouching(){
        if(getIntersectingObjects(Actor.class).size() > 0){
            return true;
        }
        return false;
    }
    @Override
    public void act(){

    }
}
