package sample;

import mayflower.Mayflower;

public class themeMenuButton extends Button {
    public themeMenuButton(String change_theme) {
        super(change_theme);
    }

    @Override
    public void OnClick() {
        Mayflower.setWorld(new themeMenu());
    }

}
