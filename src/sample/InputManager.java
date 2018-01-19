package sample;

public class InputManager {
import mayflower.Actor;
import mayflower.Keyboard;
import mayflower.Mayflower;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class InputManager extends Actor{
    private Map<Integer, Action> actionMap;
    private Set<Integer> keysPressed;
    public InputManager(){
        actionMap = getActionMap();
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

    @Override
    public void act() {
        for(Integer k : actionMap.keySet()){
            int key = k.intValue();
            if(Mayflower.isKeyDown(key) && !keysPressed.contains(k)){

            }
        }
    }
}
