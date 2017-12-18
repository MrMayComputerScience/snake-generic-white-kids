package sample;


public class StarWarsButton extends Button {
    GameInfo info;
    public StarWarsButton(String dir, GameInfo info)
    {
        super(dir);
        this.info = info;
    }

    @Override
    public void OnClick() {
        info.setGameTheme(3);
    }

}
