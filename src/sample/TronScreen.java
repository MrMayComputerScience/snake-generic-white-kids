package sample;

import mayflower.Mayflower;
import mayflower.World;

public class TronScreen extends World {
    private GameInfo info;
    private Button yes;
    private Button no;
    public TronScreen(GameInfo info, World toContinue){
        this.info = info;
        yes = new Button("yes.jpg"){
            public void OnClick(){
                info.setTron(true);
                Mayflower.setWorld(toContinue);
            }
        };
        no = new Button("no.jpg") {
            @Override
            public void OnClick() {
                info.setTron(false);
                Mayflower.setWorld(toContinue);
            }
        };
        showText("ACTiVAT3 Tr0n M0D3??2",400,200 );
        addObject(yes, 300, 350);
        addObject(no, 500, 350);
    }
    @Override
    public void act(){

    }
}
