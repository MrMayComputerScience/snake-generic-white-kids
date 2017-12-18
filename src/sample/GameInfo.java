package sample;

public class GameInfo {
    private int gameTheme;
    private int numPlayers;
    private boolean hasPortals;
    private boolean tronMode;
    public GameInfo(){
        setGameTheme(1);

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


