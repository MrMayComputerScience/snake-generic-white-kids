package sample;


public class PortalStage extends peachStage {
    public PortalStage() {
        super();
        Portal p1 = new Portal(1);
        addObject(p1, 240, 240);
        p1.createPair(120,120);
    }
}
