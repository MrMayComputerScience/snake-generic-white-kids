package sample;

import mayflower.Mayflower;
import mayflower.World;


public class PortalSelectScreen extends World {
    private Button yes;
    private Button no;
    public PortalSelectScreen(GameInfo info, World toContinue){
        System.out.println("/////////////////////////////////////////////////////////////////");
        yes = new Button("yes.jpg"){
            public void OnClick(){
                System.out.println("OnYes");
                info.setHasPortals(true);
                if(info.isTwitchPlays()){
                    TwitchPlaysGameModeManager gm = new TwitchPlaysGameModeManager(info.getNumPlayers(), info);
                    gm.setWorldAndStart(toContinue);
                }
                else{
                    StandardGameModeManager gm = StandardGameModeManager.getInstance(info);
                    gm.setWorldAndStart(toContinue);
                }


            }
        };
        no = new Button("no.jpg") {
            @Override
            public void OnClick() {
                System.out.println("OnNo");
                info.setHasPortals(false);
                if(info.isTwitchPlays()){
                    TwitchPlaysGameModeManager gm = new TwitchPlaysGameModeManager(info.getNumPlayers(), info);
                    gm.setWorldAndStart(toContinue);
                }
                else{
                    StandardGameModeManager gm = StandardGameModeManager.getInstance(info);
                    gm.setWorldAndStart(toContinue);
                }
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
