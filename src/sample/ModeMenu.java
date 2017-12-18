package sample;
import mayflower.*;
public class ModeMenu extends World {
    private int num;
    private FreeForAllButton ffa;
    private BackButton bb;
    private TwitchPlaysButton tpb;
    private SvMButton svm;
    private GameInfo info;
    public ModeMenu(int players, GameInfo info){
        this.info = info;
        showText("Select Game Mode", 250, 50);
        num = players;
        ffa = new FreeForAllButton(num, info);
        addObject(ffa, 125,200);

        if(num >= 3){
            tpb = new TwitchPlaysButton(num, info);
            addObject(tpb, 325, 200);
        }
        if(num == 4){
            svm = new SvMButton(info);
            addObject(svm,525,200);
        }

        bb = new BackButton("backbutton.png", info);
        addObject(bb, 50,500);


    }

    public void act() {

    }
}