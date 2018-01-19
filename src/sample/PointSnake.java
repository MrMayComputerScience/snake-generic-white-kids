package sample;

import com.sun.istack.internal.NotNull;
import mayflower.Actor;
import mayflower.Direction;

import java.util.List;

public class PointSnake extends SnakeActor {
    public PointSnake(int id, GameInfo info){
        super(id, info);
    }

    /**
     * setProperRotation()
     * @param peach  - the peach object on the same stage as this actor
     * Using the current rotation of this snake head, determine the proper rotation to have
     * in order to move towards the peach
     */
    private void setProperRotation(@NotNull Peach peach){
        simplifyRotation();
        //If the peach is to the right of this, do a one-step adjustment of rotation
        if(peach.getX() > getX()){
            switch(getRotation()){
                case Direction.EAST:
                    //nop
                    break;
                case Direction.NORTH:
                    setRotation(Direction.EAST);
                    break;
                case Direction.SOUTH:
                    setRotation(Direction.EAST);
                    break;
                case Direction.WEST:
                    setRotation(Math.random() >= 0.5 ?
                            Direction.NORTH : Direction.SOUTH);
            }
        }
        //If the peach is to the left, adjust by one step
        else if(peach.getX() < getX()){
            switch(getRotation()){
                case Direction.EAST:
                    setRotation(Math.random() >= 0.5 ?
                            Direction.NORTH : Direction.SOUTH);
                    break;
                case Direction.NORTH:
                    setRotation(Direction.WEST );
                    break;
                case Direction.SOUTH:
                    setRotation(Direction.WEST);
                    break;
                case Direction.WEST:
                    //nop
                    break;
            }
        }
        //If the peach is below this
        else if(peach.getY() > getY()){
            switch(getRotation()){
                case Direction.NORTH:
                    setRotation(Math.random() >= 0.5 ?
                        Direction.EAST : Direction.WEST);
                    break;
                case Direction.SOUTH:
                    //nop
                    break;
                case Direction.EAST:
                    setRotation(Direction.SOUTH);
                    break;
                case Direction.WEST:
                    setRotation(Direction.SOUTH);
                    break;
            }
        }
        //If the peach is above this
        else if(peach.getY() < getY()){
            switch(getRotation()){
                case Direction.NORTH:
                    //nop
                    break;
                case Direction.SOUTH:
                    setRotation(Math.random() >= 0.5 ?
                            Direction.EAST : Direction.WEST);
                    break;
                case Direction.EAST:
                    setRotation(Direction.NORTH);
                    break;
                case Direction.WEST:
                    setRotation(Direction.NORTH);
                    break;
            }
        }
    }

    /**
     * @param cls the class of actor to predict collisions with
     * @param depth the depth at which you wish to predict collisions
     *
     * @return the depth of the first collision, 0 if no collisions
     */
    private int predictCollision(Class<? extends Actor> cls, int depth){
        int depthOfCollision = 0;
        simplifyRotation();
        for(int i = 1; i <= depth; i++){
            int x = getCenterX();
            int y = getCenterY();
            if(getRotation() == Direction.NORTH)
                y -= i * 20; //20 is the snake-unit constant
            else if(getRotation() == Direction.SOUTH)
                y += i * 20;
            else if(getRotation() == Direction.EAST)
                x += i * 20;
            else if(getRotation() == Direction.WEST)
                x -= i * 20;
            else{
                System.err.printf("PointSnake #%d is not facing a cardinal direction! It is at %d degrees\n", getId(), getRotation());
            }

            if(getWorld().getObjectsAt(x,y, cls).size() > 0){
                System.out.println("COLLISION DETECTED IN "+i);
                System.out.println("FACING DIRECTION "+getRotation());

                depthOfCollision = i;
                break;
            }


        }
        return depthOfCollision;
    }

    /**
     * This method reduces the angle value of this object's rotation so that it is within the range
     * [-180, 180], inclusive, yet still retains its angular significance. This method is useful
     * because {@link Direction}'s values are all within this range and using {@link Actor}.turn()
     * can raise the rotation value such that it can no longer be compared to the values given
     */
    private void simplifyRotation(){
        if(getRotation() > 180)
            while(getRotation() > 180)
                setRotation(getRotation() - 360);
        else if(getRotation() < -180)
            while(getRotation() < -180)
                setRotation(getRotation() + 360);
    }
    @Override
    protected void moveSnake(){
        if(getMyWorld() instanceof peachStage){
            int dist = 3;
            peachStage stage = (peachStage)getMyWorld();
            try{
                Peach peach = stage.getObjects(Peach.class).get(0);
                setProperRotation(peach);
                if(predictCollision(wall.class, 1) > 0){
                    turn(Direction.RIGHT);
                    System.out.println("TURNING RIGHT WALL");
                }
                for(int i = 0; i < dist; i++){
                    if(predictCollision(SnakeTail.class, dist) > 0){
                        turn(Direction.RIGHT);
                        System.out.println("TURNING RIGHT BC OF TAIL #"+i);
                    }
                    else
                        break;
                }

                /*
                TODO: 2. Make snake recognize a bad collision (wall, tail, etc)
                TODO: 3. Make snake avoid collisions
                 */
            }
            catch(IndexOutOfBoundsException e){
                System.err.printf("Snake #%d tried to find the peach while there was no peach on the stage.\n", getId());
            }

        }
    }
    @Override
    public void act(){
        super.act();
    }
}
