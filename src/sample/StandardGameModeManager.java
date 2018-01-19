package sample;

import mayflower.Mayflower;

public class StandardGameModeManager extends AbstractGameModeManager {

    public StandardGameModeManager(GameInfo info){
        super(info);
        info.setGameModeManager(this);
        if(info.getNumPlayers() > 1){
            setWorld(new MultiStage(info.getNumPlayers(), info));
        }

    }
    @Override
    public void process(Action action) {
        for(int i = 0; i < getSnakes().size(); i++){
            SnakeActor snek = getSnake(i);
            int id = snek.getId();
            if(Action.valueOf("P"+id+"U") == action){
                snek.turnUp();
            }
            else if(Action.valueOf("P"+id+"D") == action){
                snek.turnDown();
            }
            else if(Action.valueOf("P"+id+"L") == action){
                snek.turnLeft();
            }
            else if(Action.valueOf("P"+id+"R") == action){
                snek.turnRight();
            }
            else if(action == Action.TICK){
                snek.tick();
            }

        }

    }

    @Override
    public void process(Action action, SnakeActor snek) {
        if(action == Action.COLLECT){
            snek.collect();
        }
        else if(action == Action.DIE){
            snek.die();
        }
        else if(action == Action.GROW){
            snek.grow();
        }
    }
}
