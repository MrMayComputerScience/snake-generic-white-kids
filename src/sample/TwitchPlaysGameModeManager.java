package sample;
import mayflower.*;

import java.util.List;

public class TwitchPlaysGameModeManager extends AbstractGameModeManager {
    private int players;

    public TwitchPlaysGameModeManager(int numPlayers, GameInfo info){
        players = numPlayers;
        addSnake(new TwitchSnakeActor(players, 1 , info));
        setWorld(new peachStage(info));
    }
    public void process(Action action){
        
    }
}
