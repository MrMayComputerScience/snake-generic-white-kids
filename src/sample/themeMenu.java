package sample;

import mayflower.World;

public class themeMenu extends World{
    Button mainMenuButton;
    Button defaultThemeButton;
    Button themePickButton;
    private GameInfo info;
    public themeMenu(GameInfo info)
    {
        this.info = info;
        mainMenuButton = new MainScreenButton("MainButton.png", this.info);
        defaultThemeButton = new defaultThemeButton("DefaultTheme.png");
        themePickButton = new themePickingButton("PickTeam.png");
        addObject(mainMenuButton, 400,450);
        addObject(themePickButton, 200, 250);
        addObject(defaultThemeButton, 400,400);
    }

    @Override
    public void act() {

    }
}
