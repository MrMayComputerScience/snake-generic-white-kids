package sample;

import mayflower.net.Server;

import java.util.HashMap;
import java.util.Map;

public class SnakeServer extends Server {
    private Map<Integer, Integer> map;
    public static final int DEFAULT_PORT = 6969;
    private long count;
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

        map = new HashMap<>();
        count = Long.MIN_VALUE;
        updateThread.start();
    }
    @Override
    public void process(int i, String s) {
        System.out.println(s);
        send(s);
    }

    @Override
    public void onJoin(int i) {

    }

    @Override
    public void onExit(int i) {

    }
    public synchronized void send(String message){
        super.send((count++)+" "+message); //count++ because we are starting at MIN_VALUE so this will use minval before incrementing
    }
    public synchronized void send(int i, String message){
        super.send(i, message);
    }
    public static SnakeServer getLocalServer(){
        SnakeServer ss = new SnakeServer(2112);

        return ss;
    }
}
