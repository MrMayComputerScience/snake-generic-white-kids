package sample;

import mayflower.Mayflower;

public class themeMenuButton extends Button {
    private GameInfo info;
    public themeMenuButton(String change_theme, GameInfo info) {
        super(change_theme);
        this.info = info;
    }

    @Override
    public void OnClick() {
        Mayflower.setWorld(new themeMenu(info));
    }

}
