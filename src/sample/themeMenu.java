package sample;

import mayflower.World;

public class themeMenu extends World{
    Button mainMenuButton;
    Button defaultThemeButton;
    Button themePickButton;
    public themeMenu()
    {
        mainMenuButton = new MainScreenButton("MainButton.png");
        defaultThemeButton = new defaultThemeButton("DefaultTheme.png");
        themePickButton = new themePickingButton("PickTheme.png");
        addObject(mainMenuButton, 400,450);
        addObject(themePickButton, 200, 250);
        addObject(defaultThemeButton, 400,400);
    }

    @Override
    public void act() {

    }
}
