package sample;
import mayflower.*;

import java.util.List;

public class TwitchPlaysGameModeManager extends AbstractGameModeManager {
    private int players;
<<<<<<< HEAD
=======

>>>>>>> CP
    private SnakeActor tSnake;
    private World tWorld;
<<<<<<< HEAD
    public TwitchPlaysGameModeManager(GameInfo info){
        super(info);
        players = info.getNumPlayers();
=======
    private List<Action> playerPresses;
<<<<<<< HEAD
=======

>>>>>>> CP
    public TwitchPlaysGameModeManager(int numPlayers, GameInfo info){
        super(info);
        players = numPlayers;
>>>>>>> origin/mason
        addSnake(new TwitchSnakeActor(players, 1 , info));
        setWorld(new peachStage(info));

<<<<<<< HEAD
    }
    public void process(Action action, SnakeActor snake){
        tSnake = getSnake(0);
        tWorld = getWorld();
    }
    public void process(Action action){
        //Strings are temporary, may change once mason creates them officially
        if(action == Action.P1_UP){
            tSnake.turnUp();
        }
        if(action == Action.P1_DOWN){
            tSnake.turnDown();
        }
        if(action == Action.P1_LEFT){
            tSnake.turnLeft();
        }
        if(action == Action.P1_RIGHT){
            tSnake.turnRight();
        }
=======
    }
    public void process(Action action){
        //Strings are temporary, may change once mason creates them officially

        makeKeyPresses(action);
        if(action == Action.COLLECT){
            tSnake.collect();
        }
        if(action == Action.DIE){
            tSnake.die();
        }
        if(action == Action.GROW){
            tSnake.grow();
        }
        if(action == Action.TICK){
            tSnake.tick();
        }


    }
    public void process(Action action, SnakeActor s){


    }
    public void makeKeyPresses(Action action){
        if(action == Action.P1_UP || action == Action.P1_DOWN || action == Action.P1_LEFT || action == Action.P1_RIGHT ||
                action == Action.P2_UP || action == Action.P2_DOWN || action == Action.P2_LEFT || action == Action.P2_RIGHT ||
                action == Action.P3_UP || action == Action.P3_DOWN || action == Action.P3_LEFT || action == Action.P3_RIGHT ||
                action == Action.P4_UP || action == Action.P4_DOWN || action == Action.P4_LEFT || action == Action.P4_RIGHT){
            playerPresses.add(action);
        }
        else if(action == Action.P1_RELEASE){
            for(Action a : playerPresses){
                if(a == Action.P1_UP || a == Action.P1_DOWN || a == Action.P1_LEFT || a == Action.P1_RIGHT){
                    playerPresses.remove(a);
                }
            }
        }
        else if(action == Action.P2_RELEASE){
            for(Action a : playerPresses){
                if(a == Action.P2_UP || a == Action.P2_DOWN || a == Action.P2_LEFT || a == Action.P2_RIGHT){
                    playerPresses.remove(a);
                }
            }
        }
        else if(action == Action.P3_RELEASE){
            for(Action a : playerPresses){
                if(a == Action.P3_UP || a == Action.P3_DOWN || a == Action.P3_LEFT || a == Action.P3_RIGHT){
                    playerPresses.remove(a);
                }
            }
        }
        else if(action == Action.P4_RELEASE){
            for(Action a : playerPresses){
                if(a == Action.P4_UP || a == Action.P4_DOWN || a == Action.P4_LEFT || a == Action.P4_RIGHT){
                    playerPresses.remove(a);
                }
            }
        }
        if(playerPresses.size() >= 4){
            if(playerPresses.contains(Action.P1_UP) && playerPresses.contains(Action.P2_UP) && playerPresses.contains(Action.P3_UP) && playerPresses.contains(Action.P4_UP)){
                tSnake.turnUp();
            }
            else if(playerPresses.contains(Action.P1_DOWN) && playerPresses.contains(Action.P2_DOWN) && playerPresses.contains(Action.P3_DOWN) && playerPresses.contains(Action.P4_DOWN)){
                tSnake.turnDown();
            }
            else if(playerPresses.contains(Action.P1_LEFT) && playerPresses.contains(Action.P2_LEFT) && playerPresses.contains(Action.P3_LEFT) && playerPresses.contains(Action.P4_LEFT)){
                tSnake.turnLeft();
            }
            else if((playerPresses.contains(Action.P1_RIGHT) && playerPresses.contains(Action.P2_RIGHT) && playerPresses.contains(Action.P3_RIGHT) && playerPresses.contains(Action.P4_RIGHT))){
                tSnake.turnRight();
            }
        }

>>>>>>> CP
    }

}
