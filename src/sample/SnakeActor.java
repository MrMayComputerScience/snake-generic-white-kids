package sample;

import mayflower.Actor;

public class SnakeActor extends Actor {

    public SnakeActor()
    {
        setImage("eggplantsnake.jpg");
    }

    public void act(){

    }
    class SnakeTail extends Actor{
        
        @Override
        public void act(){

        }
    }
}