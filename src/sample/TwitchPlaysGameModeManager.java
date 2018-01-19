package sample;
import mayflower.*;

import java.util.List;

public class TwitchPlaysGameModeManager extends AbstractGameModeManager {
    private int players;
    private SnakeActor tSnake;
    private World tWorld;
    public TwitchPlaysGameModeManager(int numPlayers, GameInfo info){
        players = numPlayers;
        addSnake(new TwitchSnakeActor(players, 1 , info));
        setWorld(new peachStage(info));
        tSnake = getSnake(0);
        tWorld = getWorld();
    }
    public void process(String action){
        //Strings are temporary, may change once mason creates them officially
        if(action.equals("p1up")){
            tSnake.turnUp();
        }
        if(action.equals("p1down")){
            tSnake.turnDown();
        }
        if(action.equals("p1left")){
            tSnake.turnLeft();
        }
        if(action.equals("p1right")){
            tSnake.turnRight();
        }
    }
}
