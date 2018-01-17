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
        tSnake = new TwitchSnakeActor(players, 1,info);
         tSnake = getSnake(0);
        tWorld = getWorld();
    }
    public void process(String action){
        
    }
}
