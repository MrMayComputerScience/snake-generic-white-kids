package sample;
import mayflower.*;
import mayflower.test.TestWorld;
import mayflower.test.astar.MyWorld;

public class Main{
    public static void main(String[] args){
        Mayflower may = new Mayflower("Test", 800, 600){
            @Override
            public void init() {
                setWorld(new TestWorld());
            }
        };
        may.init();
    }

}
