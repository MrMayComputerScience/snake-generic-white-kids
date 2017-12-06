package sample;

import mayflower.*;
import sample.SnakeActor;

public class TwitchSnakeActor extends SnakeActor {
    private int num;
    public TwitchSnakeActor(int x){
        super();
        num = x;
    }
    public void moveSnake(){
        if(num == 3){
            if(Mayflower.isKeyDown(Keyboard.KEY_W) && Mayflower.isKeyDown(Keyboard.KEY_Y) && Mayflower.isKeyDown(Keyboard.KEY_P)){
                setRotation(Direction.NORTH);
            }
            else if(Mayflower.isKeyDown(Keyboard.KEY_S) && Mayflower.isKeyDown(Keyboard.KEY_H) && Mayflower.isKeyDown(Keyboard.KEY_SEMICOLON)){
                setRotation(Direction.SOUTH);
            }
            else if(Mayflower.isKeyDown(Keyboard.KEY_A) && Mayflower.isKeyDown(Keyboard.KEY_G) && Mayflower.isKeyDown(Keyboard.KEY_L)){
                setRotation(Direction.WEST);
            }
            else if(Mayflower.isKeyDown(Keyboard.KEY_D) && Mayflower.isKeyDown(Keyboard.KEY_J) && Mayflower.isKeyDown(Keyboard.KEY_APOSTROPHE)){
                setRotation(Direction.EAST);
            }
        }
        if(num == 4){
            if(Mayflower.isKeyDown(Keyboard.KEY_W) && Mayflower.isKeyDown(Keyboard.KEY_Y) && Mayflower.isKeyDown(Keyboard.KEY_P) && Mayflower.isKeyDown(Keyboard.KEY_UP)){
                setRotation(Direction.NORTH);
            }
            else if(Mayflower.isKeyDown(Keyboard.KEY_S) && Mayflower.isKeyDown(Keyboard.KEY_H) && Mayflower.isKeyDown(Keyboard.KEY_SEMICOLON) && Mayflower.isKeyDown(Keyboard.KEY_DOWN)){
                setRotation(Direction.SOUTH);
            }
            else if(Mayflower.isKeyDown(Keyboard.KEY_A) && Mayflower.isKeyDown(Keyboard.KEY_G) && Mayflower.isKeyDown(Keyboard.KEY_L) && Mayflower.isKeyDown(Keyboard.KEY_LEFT)){
                setRotation(Direction.WEST);
            }
            else if(Mayflower.isKeyDown(Keyboard.KEY_D) && Mayflower.isKeyDown(Keyboard.KEY_J) && Mayflower.isKeyDown(Keyboard.KEY_APOSTROPHE) && Mayflower.isKeyDown(Keyboard.KEY_RIGHT)){
                setRotation(Direction.EAST);
            }
        }

    }

}
