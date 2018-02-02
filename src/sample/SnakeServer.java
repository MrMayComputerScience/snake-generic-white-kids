package sample;

import mayflower.Mayflower;
import mayflower.net.Server;
import org.jetbrains.annotations.Contract;

import java.util.*;

public class SnakeServer extends Server {
    private Map<Integer, Integer> playerMap;
    public static final int DEFAULT_PORT = 6969;
    private long msgId;
    private int snakeId;
    private Queue<Integer> standardLobby;   //This is all broken
    private Queue<Integer> twitchLobby;     //None of this will work
    private Queue<Integer> svmLobby;
    private Queue<Integer> tronLobby;
    public SnakeServer(int port){
        super(port);
        snakeId = 0;

        standardLobby = new LinkedList<>();
        twitchLobby = new LinkedList<>();
        svmLobby = new LinkedList<>();
        tronLobby = new LinkedList<>();

        playerMap = new HashMap<>();
        msgId = Long.MIN_VALUE;
    }
    @Override
    public void process(int i, String s) {
        String id = playerMap.get(i).toString();
        System.out.printf("MESSAGE FROM CLIENT %d:\n%s\n",i, s);
        if(s.contains(id)){ //TODO Fix this condition so it is less exploitable
            send(s);
        }
        else{
            System.err.println("INVALID CONTROL ATTEMPT");
        }

    }

    @Override
    public void onJoin(int i){
        playerMap.put(i, (++snakeId % 4) +1); //Increment snakeId, mod by four then add one to match snakeId
        snakeId %= 4;
        if(playerMap.size() % 4 == 0){
            for(int iter = i; iter > i-4; --iter){
                send(iter, Action.START_GAME.toString());
            }
        }
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
     * This method changes the behavior of the process method to work on single-computer games
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
