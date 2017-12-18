package sample;

import mayflower.World;

public class themeMenu extends World{
    Button mainMenuButton;
    Button defaultThemeButton;
    Button themePickButton;
    public themeMenu(GameInfo info)
    {
        mainMenuButton = new MainScreenButton("MainButton.png", info);
        defaultThemeButton = new defaultThemeButton("DefaultTheme.png");
        themePickButton = new themePickingButton("PickTeam.png");
    Button peachButt;
    Button marioButt;
    Button starButt;
    private GameInfo info;
    public themeMenu(GameInfo info)
    {
        this.info = info;
        mainMenuButton = new MainScreenButton("MainButton.png", this.info);
        peachButt = new PeachButton("peach.png", info);
        marioButt = new MarioButton("mario.jpg", info);
        starButt = new StarWarsButton("darth.jpg", info);

>>>>>>> Trevor
        addObject(mainMenuButton, 400,450);
        addObject(peachButt, 100, 100);
        addObject(marioButt, 200, 200);
        addObject(starButt, 300, 300);

    }

    @Override
    public void act() {

    }
}
