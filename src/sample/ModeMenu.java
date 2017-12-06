package sample;
import mayflower.*;
public class ModeMenu extends World {
    private int num;
    private FreeForAllButton ffa;
    private BackButton bb;
    private TwitchPlaysButton tpb;
    public ModeMenu(int players){
        showText("Select Game Mode", 250, 50);
        num = players;
        ffa = new FreeForAllButton(num);
        addObject(ffa, 125,200);

        if(num >= 3){
            tpb = new TwitchPlaysButton(num);
            addObject(tpb, 325, 200);
        }

        bb = new BackButton("backbutton.png");
        addObject(bb, 50,500);


    }

    public void act() {

    }
}