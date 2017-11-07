package sample;

import mayflower.*;




public class SnakeActor extends Actor implements Direction{
    private Timer t = new Timer();
    public SnakeActor()
    {
        setImage("eggplantsnake.jpg");
        t = new Timer(75);
    }

    public void act(){

        if(t.isDone()){
            //System.out.println(t.toString());
            t.reset();
            if (Mayflower.isKeyDown(Keyboard.KEY_UP) || Mayflower.isKeyDown(Keyboard.KEY_W)) {
                setRotation(Direction.NORTH);
            }
            else if (Mayflower.isKeyDown(Keyboard.KEY_DOWN) || Mayflower.isKeyDown(Keyboard.KEY_S)) {
                setRotation(Direction.SOUTH);
            }
            else if (Mayflower.isKeyDown(Keyboard.KEY_LEFT) || Mayflower.isKeyDown(Keyboard.KEY_A)) {
                setRotation(Direction.WEST);
            }
            else if (Mayflower.isKeyDown(Keyboard.KEY_RIGHT) || Mayflower.isKeyDown(Keyboard.KEY_D)) {
                setRotation(Direction.EAST);
            }
            move(20);
        }







    }

}