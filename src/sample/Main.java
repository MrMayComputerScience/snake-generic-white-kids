package sample;
import mayflower.*;

public class Main{
    public static void main(String[] args){
        Mayflower m = new Mayflower("Test", 800, 600) {
            @Override
            public void init() {
                setWorld(new PeachStage());
            }
        };
        m.init();
    }
}
