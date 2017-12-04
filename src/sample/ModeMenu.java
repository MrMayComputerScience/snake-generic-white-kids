package sample;
import mayflower.*;
public class ModeMenu extends World {
    private int num;
    private FreeForAllButton ffa;
    public ModeMenu(int players){
        showText("Select Game Mode", 250, 50);
        num = players;
        ffa = new FreeForAllButton(num);
        addObject(ffa, 125,350);
    }

    public void act() {

    }
}