package sample;

import mayflower.Actor;

import java.util.LinkedList;
import java.util.List;

public class Peach extends Actor{
    private int x;
    private int y;

    public Peach(int i){
        if(i == 1)setPicture("peach.png");
        if(i == 2)setPicture("crystal.png");
        if(i == 3)setPicture("coin.png");

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

    public void setPicture(String name)
    {
        setImage(name);
    }
}
