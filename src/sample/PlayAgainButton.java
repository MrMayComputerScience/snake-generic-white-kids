package sample;
import mayflower.*;


public class PlayAgainButton extends Button {
    private World game;
    private GameInfo info;
    public PlayAgainButton(String name, World game, GameInfo info){

        super(name);
        this.info = info;
        this.game = game;
    }
    public void OnClick(){

        if(game instanceof MultiStage){
            MultiStage g = (MultiStage)game;
            MultiStage stage = new MultiStage(info.getNumPlayers(), info);

            Mayflower.setWorld(stage);
        }
        else if(game instanceof  peachStage){
            peachStage g = (peachStage)game;
            if(g.getSnek() instanceof TwitchSnakeActor){
                TwitchSnakeActor s = (TwitchSnakeActor)g.getSnek();
                peachStage n = new peachStage(info);
                n.setSnek(new TwitchSnakeActor(s.getNumPlayers(),1, info));
                Mayflower.setWorld(n);
            }
            else
                Mayflower.setWorld(g);

        }

        else if(game instanceof SMMultiStage){
            SMMultiStage stage = (SMMultiStage)game;
            Mayflower.setWorld(new SMMultiStage(info));
        }

    }

}
