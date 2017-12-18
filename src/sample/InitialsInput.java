package sample;

import mayflower.*;

public class InitialsInput extends World{
    private char[] pos;
    private char[] light;
    private int current;
    private final char START = 'A';
    private final char END = 'Z';
    private final char INIT = '_';
    private Label dispInits;
    private Label highlight;
    private SnakeActor actor;
    private int numPlayers;
    private GameInfo info;
    public InitialsInput(SnakeActor a, int numPlayers, GameInfo info){
        this.info = info;
        actor = a;
        this.numPlayers = numPlayers;
        pos = new char[3];
        light = new char[3];
        current = 0;
        dispInits = new Label("___",34);
        highlight = new Label("___",34);
        dispInits.setColor(Color.WHITE);
        highlight.setColor(Color.YELLOW);
        showText("Enter Your Initials!", 250, 150);
        addObject(dispInits, 300, 250);
        addObject(highlight, 300, 250);
        for(int i = 0; i < pos.length; i++){
            pos[i] = INIT;
            light[i] = ' ';
        }
        highlight.setText("_  ");
        light[0]='_';
    }
    public String getInitials(){
        return dispInits.getText();
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
            light[current] = ' ';
            if(current - 1 < 0){
                current = pos.length-1;
            }
            else{
                current--;
            }
            light[current] = '_';
            String label = "";
            StringBuilder builder = new StringBuilder();
            for(char c : light){
                builder.append(c);
            }
            label = builder.toString();
            highlight.setText(label);

        }
        else if(Mayflower.isKeyPressed(Keyboard.KEY_RIGHT) || Mayflower.isKeyPressed(Keyboard.KEY_D)){
            light[current] = ' ';
            if(current + 1 >= pos.length)
                current = 0;
            else
                current++;
            light[current] = '_';
            String label = "";
            StringBuilder builder = new StringBuilder();
            for(char c : light){
                builder.append(c);
            }
            label = builder.toString();
            highlight.setText(label);
        }
        if(Mayflower.isKeyPressed(Keyboard.KEY_ENTER)){
            actor.saveScore(getInitials());
            Mayflower.setWorld(new gameOverScreen(actor, numPlayers, info));
        }
    }
}
