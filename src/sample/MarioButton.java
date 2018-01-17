package sample;

public class MarioButton extends Button {
    GameInfo info;
    public MarioButton(String dir, GameInfo info)
    {
        super(dir);
        this.info = info;
    }

    @Override
    public void OnClick() {
        info.setGameTheme(2);
    }
}
