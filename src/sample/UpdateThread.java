package sample;

public class UpdateThread extends Thread {
    private SnakeServer server;
    public UpdateThread(SnakeServer ss){
        server = ss;
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
                server.send(Action.TICK.toString());
            }
        }
    }
}
