package sample;
import mayflower.*;
public class ControlsScreen extends World{
    private int num;
    private ContinueButton cb;
    private BackButton bb;
    private KeyActor wkey;
    private KeyActor akey;
    private KeyActor skey;
    private KeyActor dkey;

    private KeyActor ykey;
    private KeyActor gkey;
    private KeyActor hkey;
    private KeyActor jkey;

    private KeyActor pkey;
    private KeyActor lkey;
    private KeyActor semikey;
    private KeyActor aposkey;

    private KeyActor upkey;
    private KeyActor leftkey;
    private KeyActor downkey;
    private KeyActor rightkey;
    public ControlsScreen(int players){
            num = players;
            cb = new ContinueButton("ContinueButton.png", num);
            bb = new BackButton("backbutton.png");
            //player one
            wkey = new KeyActor("W.png");
            addObject(wkey, 150,100);
            akey = new KeyActor("A.png");
            addObject(akey,75,175);
            skey = new KeyActor("S.png");
            addObject(skey, 150, 175);
            dkey = new KeyActor("D.png");
            addObject(dkey, 225, 175);
            //player two
            ykey = new KeyActor("Y.png");
            addObject(ykey, 500,100);
            gkey = new KeyActor("G.png");
            addObject(gkey,425,175);
            hkey = new KeyActor("H.png");
            addObject(hkey, 500, 175);
            jkey = new KeyActor("J.png");
            addObject(jkey, 575, 175);
            //player three
            if(num >= 3){
                pkey = new KeyActor("P.png");
                addObject(pkey, 150,350);
                lkey = new KeyActor("L.png");
                addObject(lkey,75,425);
                semikey = new KeyActor("semicolon.png");
                addObject(semikey, 150, 425);
                aposkey = new KeyActor("apostrophe.png");
                addObject(aposkey, 225, 425);
                showText("Player Three", 100,300);
            }

            //player four
            if( num == 4){
                upkey = new KeyActor("up.png");
                addObject(upkey, 500,350);
                leftkey = new KeyActor("left.png");
                addObject(leftkey,425,425);
                downkey = new KeyActor("down.png");
                addObject(downkey, 500, 425);
                rightkey = new KeyActor("right.png");
                addObject(rightkey, 575, 425);
                showText("Player Four", 460,300);
            }



            showText("Player One", 100,50);
            showText("Player Two", 460,50);
            showText("Controls", 315, 15);

            addObject(bb, 25,525);
            addObject(cb, 700,525);
    }
    public void act(){

    }
}
