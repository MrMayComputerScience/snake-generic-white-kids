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
        String cmd = s.split(" ")[1];
        if(info.getGameModeManager() != null){
            info.getGameModeManager().process(Action.getAction(cmd));
        }
    }

    @Override
    public void onDisconnect(String s) {
    }

    @Override
    public void onConnect() {
        send("Howdy pardner!");
    }
}
