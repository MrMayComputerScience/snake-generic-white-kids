package sample;


public class PortalStage extends peachStage {
    private GameInfo info;
    public PortalStage(GameInfo info) {
        super(info);
        this.info = info;
        Portal p1 = new Portal(1);
        addObject(p1, 240, 240);
        p1.createPair(120,120);
    }
}
