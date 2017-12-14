package sample;

public class GameInfo {
    private int gameTheme;
    private int numPlayers;
    private boolean hasPortals;
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

    public boolean isHasPortals() {
        return hasPortals;
    }

    public void setHasPortals(boolean hasPortals) {
        this.hasPortals = hasPortals;
    }
}
