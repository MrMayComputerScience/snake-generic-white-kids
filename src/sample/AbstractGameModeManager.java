package sample;
import mayflower.*;
import java.util.List;

public abstract class AbstractGameModeManager {
    private List<SnakeActor> sneks;
    private World snakeWorld;
    private GameInfo info;
    public AbstractGameModeManager(GameInfo info){
        this.info = info;
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
    public abstract void process(Action action, SnakeActor a);
}
