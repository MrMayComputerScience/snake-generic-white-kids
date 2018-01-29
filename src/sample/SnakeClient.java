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
            AbstractGameModeManager gm = info.getGameModeManager();
            SnakeActor actor = null;
            //Find the affected snake
            for(SnakeActor a : gm.getSnakes()){
                if(a.getId() == id)
                    actor = a;
            }

            synchronized (info){
                if(actor != null)
                    info.getGameModeManager().process(Action.getAction(cmd), actor);
                else
                    System.err.println("ACTOR IS NULL IN CLIENT.PROCESS");
            }

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

    }
}
