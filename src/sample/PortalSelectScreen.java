package sample;

import mayflower.Mayflower;
import mayflower.World;


public class PortalSelectScreen extends World {
    private Button yes;
    private Button no;
    public PortalSelectScreen(GameInfo info, World toContinue){
        yes = new Button("yes.jpg"){
            public void OnClick(){
                info.setHasPortals(true);
                if(toContinue instanceof MultiStage)
                    Mayflower.setWorld(new TronScreen(info, toContinue));
                else
                    Mayflower.setWorld(toContinue);
            }
        };
        no = new Button("no.jpg") {
            @Override
            public void OnClick() {
                info.setHasPortals(false);
                if(toContinue instanceof MultiStage)
                    Mayflower.setWorld(new TronScreen(info, toContinue));
                else
                    Mayflower.setWorld(toContinue);
            }
        };
        showText("Want portlasl!>?",400,200 );
        addObject(yes, 300, 350);
        addObject(no, 500, 350);
    }
    @Override
    public void act() {

    }
}
