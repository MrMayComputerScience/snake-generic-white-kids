package sample;

import mayflower.net.Client;

/*
So heres the thing: There could be a bug that one command gets to a player before its preceding command.
I hope it is super unlikely, and thus will not implement a bug fix until
 */
public class SnakeClient extends Client {
    private GameInfo info;

    public SnakeClient(GameInfo info) {
        this.info = info;
    }

    @Override
    public void process(String s) {
        System.out.println("SERVER: " + s);
        String[] split = s.split(" ");
        //If its not a command, don't execute it
        if (split[0].split("-?\\d+").length != 0)
            return;

        String cmd = split[1];
        if (split.length == 3) {
            int id = Integer.parseInt(split[2]);
            SnakeActor actor = info.getGameModeManager().getSnake(id);
            info.getGameModeManager().process(Action.getAction(cmd), actor);
        }
        if (info.getGameModeManager() != null) {
            synchronized (info) {
                info.getGameModeManager().process(Action.getAction(cmd));
            }

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
