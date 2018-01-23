package sample;
import mayflower.*;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGameModeManager {
    private List<SnakeActor> sneks;
    private World snakeWorld;
    private GameInfo info;
    public AbstractGameModeManager(GameInfo info){
        this.info = info;
        info.setGameModeManager(this);
        sneks = new ArrayList<>(8);
    }
    public List<SnakeActor> getSnakes(){
        return sneks;
    }
    public SnakeActor getSnake(int index){
        return sneks.get(index);
    }
    public World getWorld(){
        return snakeWorld;
    }
    public void addSnake(SnakeActor s){
        if(!sneks.contains(s))
            sneks.add(s);
    }
    public void setWorld(World wd){
        snakeWorld = wd;
        wd.addObject(info.getInputManager(), 42, 42);
        for(SnakeActor a : wd.getObjects(SnakeActor.class))
            addSnake(a);
    }
    public void setWorldAndStart(World wd){
        setWorld(wd);
        Mayflower.setWorld(wd);
    }
    public void start(){
        if(snakeWorld != null){
            Mayflower.setWorld(snakeWorld);
        }
        else
            System.err.println("Trying to start a GameModeManager where the world has not been set");
    }
    protected GameInfo getInfo(){return info;}
    public abstract void process(Action action);
    public abstract void process(Action action, SnakeActor a);

}
