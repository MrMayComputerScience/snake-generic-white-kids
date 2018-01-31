package sample;

import mayflower.Mayflower;
import mayflower.net.Server;
import org.jetbrains.annotations.Contract;

import java.util.HashMap;
import java.util.Map;

public class SnakeServer extends Server {
    private Map<Integer, Integer> playerMap;
    public static final int DEFAULT_PORT = 6969;
    private long msgId;
    private int snakeId;
    private Thread updateThread;
    public SnakeServer(int port){
        super(port);

        final SnakeServer s = this;
        updateThread = new Thread(() -> {
            long timeLastUpdate = System.currentTimeMillis();
            long target = 75;
            SnakeServer server = s;
            for(;;){
                long elapsed = System.currentTimeMillis() - timeLastUpdate;
                if(elapsed >= target){
                    long over = elapsed - target;
                    target = 75-over;
                    timeLastUpdate = System.currentTimeMillis();
                    s.send(Action.TICK.toString());
                }
            }
        });
        snakeId = 0;
        playerMap = new HashMap<>();
        msgId = Long.MIN_VALUE;
        updateThread.start();
    }
    @Override
    public void process(int i, String s) {
        String id = playerMap.get(i).toString();
        if(s.contains(id)){
            System.out.printf("MESSAGE FROM CLIENT %d:\n%s\n",i, s);
            send(s);
        }

    }

    @Override
    public void onJoin(int i){
        playerMap.put(i, (++snakeId % 4) +1); //Increment snakeId, mod by four then add one to match snakeId
    }

    @Override
    public void onExit(int i) {
        
    }
    public synchronized void send(String message){
        super.send((msgId++)+" "+message); //count++ because we are starting at MIN_VALUE so this will use minval before incrementing
    }
    public synchronized void send(int i, String message){
        super.send(i, message);
    }

    /**
     * This method changes the behavior of the process method to work on single-computer applications
     * @return A SnakeServer instance modified for use on a single computer, as opposed to an area network
     */
    public static SnakeServer getLocalServer(){
        SnakeServer ss = new SnakeServer(DEFAULT_PORT){
            public void process(int i, String s){
                System.out.printf("MESSAGE ON LOCAL SERVER:\n%s\n", s);
                send(s);
            }
        };
        return ss;
    }
}
