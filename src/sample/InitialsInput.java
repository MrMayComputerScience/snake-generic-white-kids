package sample;

import mayflower.*;

public class InitialsInput extends World{
    private String initials;
    private char[] pos;
    private int current;
    private final char START = 'A';
    private final char END = 'Z';
    private final char INIT = '_';
    private Label dispInits;
    public InitialsInput(){
        pos = new char[3];
        current = 0;
        dispInits = new Label("___");
        addObject(dispInits, 300, 250);
        for(int i = 0; i < pos.length; i++){
            pos[i] = INIT;
        }
    }
    public String getInitials(){
        return initials;
    }
    @Override
    public void act(){
        if(Mayflower.isKeyPressed(Keyboard.KEY_UP) || Mayflower.isKeyPressed(Keyboard.KEY_W)){
            if(pos[current] == INIT){
                pos[current] = START-1;
            }
            if(pos[current]+1 > END){
                pos[current] = START;
            }
            else{
                pos[current] += 1;
            }
            String label = "";
            StringBuilder builder = new StringBuilder();
            for(char c : pos){
                builder.append(c);
            }
            label = builder.toString();
            dispInits.setText(label);
        }
        else if(Mayflower.isKeyPressed(Keyboard.KEY_DOWN) || Mayflower.isKeyPressed(Keyboard.KEY_S)){
            if(pos[current] == INIT)
                pos[current] = END+1;
            if(pos[current] - 1 < START)
                pos[current] = END;
            else
                pos[current] -= 1;
            String label = "";
            StringBuilder builder = new StringBuilder();
            for(char c : pos){
                builder.append(c);
            }
            label = builder.toString();
            dispInits.setText(label);
        }
        else if(Mayflower.isKeyPressed(Keyboard.KEY_A) || Mayflower.isKeyPressed(Keyboard.KEY_LEFT)){
            if(current - 1 < 0)
                current = pos.length-1;
            else
                current--;
        }
        else if(Mayflower.isKeyPressed(Keyboard.KEY_RIGHT) || Mayflower.isKeyPressed(Keyboard.KEY_D)){
            if(current + 1 >= pos.length)
                current = 0;
            else
                current++;
        }
        if(Mayflower.isKeyPressed(Keyboard.KEY_ENTER)){
            Mayflower.setWorld(new gameOverScreen());
        }
    }
}
