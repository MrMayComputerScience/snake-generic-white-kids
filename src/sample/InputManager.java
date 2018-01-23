package sample;


import mayflower.Actor;
import mayflower.Keyboard;
import mayflower.Mayflower;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class InputManager extends Actor{
    private Map<Integer, Action> actionMap;
    private Map<Integer, Action> releaseMap;
    private Set<Integer> keysPressed;
    private AbstractGameModeManager gm;
    public InputManager(){
        actionMap = getActionMap();
        releaseMap.put(Keyboard.KEY_W, Action.P1_RELEASE);
        releaseMap.put(Keyboard.KEY_A, Action.P1_RELEASE);
        releaseMap.put(Keyboard.KEY_S, Action.P1_RELEASE);
        releaseMap.put(Keyboard.KEY_D, Action.P1_RELEASE);
        releaseMap.put(Keyboard.KEY_Y, Action.P2_RELEASE);
        releaseMap.put(Keyboard.KEY_G, Action.P2_RELEASE);
        releaseMap.put(Keyboard.KEY_H, Action.P2_RELEASE);
        releaseMap.put(Keyboard.KEY_J, Action.P2_RELEASE);
        releaseMap.put(Keyboard.KEY_P, Action.P3_RELEASE);
        releaseMap.put(Keyboard.KEY_L, Action.P3_RELEASE);
        releaseMap.put(Keyboard.KEY_SEMICOLON, Action.P3_RELEASE);
        releaseMap.put(Keyboard.KEY_APOSTROPHE, Action.P3_RELEASE);
        releaseMap.put(Keyboard.KEY_UP, Action.P4_RELEASE);
        releaseMap.put(Keyboard.KEY_LEFT, Action.P4_RELEASE);
        releaseMap.put(Keyboard.KEY_DOWN, Action.P4_RELEASE);
        releaseMap.put(Keyboard.KEY_RIGHT, Action.P4_RELEASE);
    }
    public static Map<Integer, Action> getActionMap(){
        Map<Integer, Action> map = new HashMap<>();
        map.put(Keyboard.KEY_W, Action.P1_UP);
        map.put(Keyboard.KEY_A, Action.P1_LEFT);
        map.put(Keyboard.KEY_S, Action.P1_DOWN);
        map.put(Keyboard.KEY_D, Action.P1_RIGHT);
        map.put(Keyboard.KEY_Y, Action.P2_UP);
        map.put(Keyboard.KEY_G, Action.P2_LEFT);
        map.put(Keyboard.KEY_H, Action.P2_DOWN);
        map.put(Keyboard.KEY_J, Action.P2_RIGHT);
        map.put(Keyboard.KEY_P, Action.P3_UP);
        map.put(Keyboard.KEY_L, Action.P3_LEFT);
        map.put(Keyboard.KEY_SEMICOLON, Action.P3_DOWN);
        map.put(Keyboard.KEY_APOSTROPHE, Action.P3_RIGHT);
        map.put(Keyboard.KEY_UP, Action.P4_UP);
        map.put(Keyboard.KEY_LEFT, Action.P4_LEFT);
        map.put(Keyboard.KEY_DOWN, Action.P4_DOWN);
        map.put(Keyboard.KEY_RIGHT, Action.P4_RIGHT);
        return map;
    }
    public void setGameModeManager(AbstractGameModeManager gm){
        this.gm = gm;
    }
    @Override
    public void act() {
        for(Integer key : actionMap.keySet()){
            if(Mayflower.isKeyDown(key)){
                if(!keysPressed.contains(key)){
                    keysPressed.add(key);
                    gm.process(actionMap.get(key));
                }
            }
            else{
                keysPressed.remove(key);
                gm.process(releaseMap.get(key));
            }

        }
    }
}
