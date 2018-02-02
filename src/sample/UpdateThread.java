package sample;

import java.util.List;

public class UpdateThread extends Thread {
    private SnakeServer server;
    private List<Integer> players;
    public UpdateThread(SnakeServer ss, List<Integer> players){
        server = ss;
        this.players = players;
    }

    public void run(){
        long timeLastUpdate = System.currentTimeMillis();
        long target = 75;
        for(;;){
            long elapsed = System.currentTimeMillis() - timeLastUpdate;
            if(elapsed >= target){
                long over = elapsed - target;
                target = 75-over;
                timeLastUpdate = System.currentTimeMillis();
                for(int i : players)
                    server.send(i, Action.TICK.toString());
            }
        }
    }
}
