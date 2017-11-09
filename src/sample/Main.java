package sample;
import mayflower.*;
<<<<<<< HEAD
import mayflower.test.TestWorld;
import org.newdawn.slick.GameContainer;
=======
>>>>>>> origin/mason

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
