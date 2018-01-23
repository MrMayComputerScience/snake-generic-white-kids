package sample;

public enum Action {
    P1_UP("P1U"),
    P1_LEFT("P1L"),
    P1_DOWN("P1D"),
    P1_RIGHT("P1R"),
    P2_UP("P2U"),
    P2_LEFT("P2L"),
    P2_DOWN("P2D"),
    P2_RIGHT("P2R"),
    P3_UP("P3U"),
    P3_LEFT("P3L"),
    P3_DOWN("P3D"),
    P3_RIGHT("P3R"),
    P4_UP("P4U"),
    P4_LEFT("P4L"),
    P4_DOWN("P4D"),
    P4_RIGHT("P4R"),
    P1_RELEASE("P1REL"),
    P2_RELEASE("P2REL"),
    P3_RELEASE("P3REL"),
    P4_RELEASE("P4REL"),
    TICK("TIC"),
    DIE("DIE"),
    COLLECT("COL"),
    GROW("GRO"),
    GAME_OVER("GMO");
    String name;
    Action(String name){
        this.name = name;
    }
    @Override
    public String toString(){
        return name;
    }
}
