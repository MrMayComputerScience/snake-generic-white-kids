package sample;

import mayflower.*;




public class SnakeActor extends Actor{
    public SnakeActor()
    {
        setImage("eggplantsnake.jpg");
    }

    public void act(){
        

        if(Mayflower.isKeyPressed(Keyboard.KEY_UP) || Mayflower.isKeyPressed(Keyboard.KEY_UP)){
           this.move(1);
           setRotation(90);
        }
        
    }

}