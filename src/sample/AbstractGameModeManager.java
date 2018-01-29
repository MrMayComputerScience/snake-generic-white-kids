package sample;
import mayflower.*;

<<<<<<< HEAD
import java.io.File;
import java.io.FileNotFoundException;
=======
>>>>>>> origin/mason
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public abstract class AbstractGameModeManager {
    GameInfo info;
    private Map<String, String> themeMap;
    private List<SnakeActor> sneks;
    private World snakeWorld;
<<<<<<< HEAD
    public AbstractGameModeManager(GameInfo info)
    {
        this.info = info;
        sneks = new ArrayList<SnakeActor>();
    }

=======
    private GameInfo info;
    public AbstractGameModeManager(GameInfo info){
        this.info = info;
        info.setGameModeManager(this);
        sneks = new ArrayList<>(8);
    }
>>>>>>> origin/mason
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
