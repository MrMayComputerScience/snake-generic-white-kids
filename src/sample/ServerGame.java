package sample;

import java.util.List;
import java.util.Map;

public class ServerGame {
    private List<Integer> players;
    private UpdateThread updateThread;
    private String gameMode;
    public ServerGame(List<Integer> players, String gameMode, SnakeServer ss){
        this.players = players;
        updateThread = new UpdateThread(ss, players);
        this.gameMode = gameMode;
    }
}
