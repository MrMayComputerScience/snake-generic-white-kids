package sample;

public class GameInfo {
    private int gameTheme;
    private int numPlayers;
    private boolean hasPortals;
    private boolean tronMode;
    private boolean isSvM;
    private boolean isTwitchPlays;
    private AbstractGameModeManager gm;
    private InputManager input;
    private SnakeClient client;

    public SnakeClient getClient() {
        return client;
    }

    public AbstractGameModeManager getGameModeManager() {
        return gm;
    }

    public void setGameModeManager(AbstractGameModeManager gm) {
        this.gm = gm;
    }

    public InputManager getInputManager() {
        return input;
    }

    public boolean isTwitchPlays() {
        return isTwitchPlays;
    }

    public void setTwitchPlays(boolean twitchPlays) {
        isTwitchPlays = twitchPlays;
    }

    public GameInfo(){
        SnakeServer server = SnakeServer.getLocalServer();
        setGameTheme(1);
        input = new InputManager();
        client = new SnakeClient(this);
        client.connect(SnakeServer.DEFAULT_PORT);
    }

    public int setGameTheme(int theme){
        int temp = gameTheme;
        gameTheme = theme;
        return temp;
    }

    public int getGameTheme(){
        return gameTheme;
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    public int setNumPlayers(int numPlayers) {
        int temp = this.numPlayers;
        this.numPlayers = numPlayers;
        return temp;
    }

    public boolean isSvM() {
        return isSvM;
    }

    public void setSvM(boolean svM) {
        isSvM = svM;
    }

    public boolean hasPortals() {
        return hasPortals;
    }

    public boolean setHasPortals(boolean hasPortals) {
        boolean temp = this.hasPortals;
        this.hasPortals = hasPortals;
        return temp;
    }

    public boolean isTron() {
        return tronMode;
    }

    public void setTron(boolean tronMode) {
        this.tronMode = tronMode;
    }
}

