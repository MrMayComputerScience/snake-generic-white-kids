package sample;
import mayflower.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public abstract class AbstractGameModeManager {
    GameInfo info;
    private Map<String, String> themeMap;
    private List<SnakeActor> sneks;
    private World snakeWorld;
    public AbstractGameModeManager(GameInfo info)
    {
        this.info = info;
        sneks = new ArrayList<SnakeActor>();
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
        sneks.add(s);
    }
    public void setWorld(World wd){
        snakeWorld = wd;
    }
    public abstract void process(Action action);
}
