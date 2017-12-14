package sample;

import mayflower.World;

public class PortalSelectScreen extends World {
    private Button yes;
    private Button no;
    public PortalSelectScreen(GameInfo info){
        yes = new Button("Yes!"){
            public void OnClick(){
                info.setHasPortals(true);
            }
        };
        no = new Button("No...") {
            @Override
            public void OnClick() {
                info.setHasPortals(false);

            }
        };
        addObject(yes, 300, 350);
        addObject(no, 500, 350);
    }
    @Override
    public void act() {

    }
}
