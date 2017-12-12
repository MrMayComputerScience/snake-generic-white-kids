package sample;
import mayflower.*;


public class PlayAgainButton extends Button {
    private World game;
    public PlayAgainButton(String name, World game){
        super(name);
        this.game = game;
    }
    public void OnClick(){
        if(game instanceof MultiStage){
            MultiStage g = (MultiStage)game;
            Mayflower.setWorld(new MultiStage(g.getNumPlayers()));
        }
        if(game instanceof  peachStage){
            peachStage g = (peachStage)game;
            if(g.getSnek() instanceof TwitchSnakeActor){
                TwitchSnakeActor s = (TwitchSnakeActor)g.getSnek();
                peachStage n = new peachStage();
                n.setSnek(new TwitchSnakeActor(s.getNumPlayers(),1));
                Mayflower.setWorld(n);
            }

        }
    }

}
