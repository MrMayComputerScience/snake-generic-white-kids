package sample;
import mayflower.*;

import java.util.List;

public class TwitchPlaysGameModeManager extends AbstractGameModeManager {
    private int players;
    private SnakeActor tSnake;
    private World tWorld;
    public TwitchPlaysGameModeManager(GameInfo info){
        super(info);
        players = info.getNumPlayers();
        addSnake(new TwitchSnakeActor(players, 1 , info));
        setWorld(new peachStage(info));
        tSnake = getSnake(0);
        tWorld = getWorld();
    }
    public void process(Action action){
        //Strings are temporary, may change once mason creates them officially
        if(action == Action.P1_UP){
            tSnake.turnUp();
        }
        if(action == Action.P1_DOWN){
            tSnake.turnDown();
        }
        if(action == Action.P1_LEFT){
            tSnake.turnLeft();
        }
        if(action == Action.P1_RIGHT){
            tSnake.turnRight();
        }
        if(action == Action.COLLECT){
            tSnake.collect();
        }
        if(action == Action.DIE){
            tSnake.die();
        }
        if(action == Action.GROW){
            tSnake.grow();
        }
        if(action == Action.TICK){
            tSnake.tick();
        }

    }
}
