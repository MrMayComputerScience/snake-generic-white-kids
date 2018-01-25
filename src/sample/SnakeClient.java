package sample;

import mayflower.net.Client;

public class SnakeClient extends Client{
    private GameInfo info;
    public SnakeClient(GameInfo info){
        this.info = info;
    }
    @Override
    public void process(String s) {
        System.out.println("SERVER: "+s);
    }

    @Override
    public void onDisconnect(String s) {
    }

    @Override
    public void onConnect() {
        send("Howdy pardner!");
    }
}
