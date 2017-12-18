package sample;


public class PeachButton extends Button {
    GameInfo info;
    public PeachButton(String dir, GameInfo info)
    {
        super(dir);
        this.info = info;
    }

    @Override
    public void OnClick() {
        info.setGameTheme(1);
    }

}
