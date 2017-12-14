package sample;

import mayflower.Actor;
import mayflower.Direction;

import java.util.List;


public class Portal extends Actor {
    private int id;
    private Portal pair;
    public Portal(int id){
    this.id = id;
    setImage("portal_"+id+".jpg");
    }
    public void setPair(Portal other){
        pair = other;
        if(pair.getPair() == null)
            pair.setPair(this);
    }
    public Portal getPair(){
        return pair;
    }
    public Portal createPair(int x, int y){
        Portal other = new Portal(id == 1 ? 2 : 1);
        if(getWorld() != null){
            getWorld().addObject(other, x, y);
            pair = other;
        }
        if(pair.getPair() == null)
            pair.setPair(this);
        return pair;
    }
    @Override
    public void act() {
        if(isTouching(SnakeActor.class)){
            onSnakeTouching(getIntersectingObjects(SnakeActor.class));
        }
    }
    public void onSnakeTouching(List<SnakeActor> snakes){
        for(SnakeActor snek : snakes){
            /*
            How Im using position here:
                  2
                3 0 1
                  4
            where 0 is the portal and the numbers are the resulting positions
             */
            int dx = 0;
            int dy = 0;
            switch(snek.getRotation()){
                case Direction.EAST:
                    dx = 1;
                    break;
                case Direction.NORTH:
                    dy = -1;
                    break;
                case Direction.WEST:
                    dx = -1;
                    break;
                case Direction.SOUTH:
                    dy = 1;
                    break;
                default:
                    dy = 1;
                    dx = 1;
                    System.out.println("What the actual hell did you do to make the rotation of the snake not a cardinal direction");
            }
            snek.setLocation(pair.getX() + (dx * 20), pair.getY() + (dy * 20));

        }
    }
}
