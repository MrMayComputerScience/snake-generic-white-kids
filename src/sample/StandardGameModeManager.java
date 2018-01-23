package sample;

import mayflower.Mayflower;

import java.util.Map;

public class StandardGameModeManager extends AbstractGameModeManager {
    private static Map<GameInfo, StandardGameModeManager> managers;
    public static StandardGameModeManager getInstance(GameInfo info) {
        if(managers.containsKey(info)){
            return managers.get(info);
        }
        else{
            StandardGameModeManager m = new StandardGameModeManager(info);
            managers.put(info, m);
            return m;
        }
    }
    private StandardGameModeManager(GameInfo info){
        super(info);
    }
    public void resetWorld(){
        if(getInfo().getNumPlayers() > 1){
            setWorld(new MultiStage(getInfo().getNumPlayers(), getInfo()));
        }
        else{
            setWorld(new peachStage(getInfo()));
        }
    }
    @Override
    public void process(Action action) {
        for(int i = 0; i < getSnakes().size(); i++){
            SnakeActor snek = getSnake(i);
            int id = snek.getId();
            if(Action.valueOf("P"+id+"U") == action){
                snek.turnUp();
            }
            else if(Action.valueOf("P"+id+"D") == action){
                snek.turnDown();
            }
            else if(Action.valueOf("P"+id+"L") == action){
                snek.turnLeft();
            }
            else if(Action.valueOf("P"+id+"R") == action){
                snek.turnRight();
            }
            else if(action == Action.TICK){
                snek.tick();
            }

        }

    }

    @Override
    public void process(Action action, SnakeActor snek) {
        if(action == Action.COLLECT){
            snek.collect();
        }
        else if(action == Action.DIE){
            snek.die();
            getSnakes().remove(snek);
            if(getSnakes().size() == 1){
                //TODO: WIN CONDITION HERE
                getSnakes().remove(0);
            }
        }
        else if(action == Action.GROW){
            snek.grow();
        }
    }
}
