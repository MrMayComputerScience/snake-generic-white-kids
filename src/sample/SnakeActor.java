package sample;

import com.sun.istack.internal.Nullable;
import mayflower.*;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class SnakeActor extends Actor{
    public static final int TICK_TIME = 75;
    private double numTicks, sumTimes = 0;
    private Timer t = new Timer();
    private int tailLength;
    private double time;
    private int lengthToAdd;
    private List<SnakeTail> tail;
    private long timeLastUpdate;
    private int tickLen;
    private int upControl;
    private int downControl;
    private int leftControl;
    private int rightControl;
    private int id;
    private boolean running;
    private World myWorld;
    private boolean tronMode;

    private int score;
    private GameInfo info;
    private int x;
    private int y;
    public SnakeActor(int di, GameInfo info)
    {
        score = 0;
        this.info = info;
        tronMode = false;
        id = di;
        tickLen = TICK_TIME;
        timeLastUpdate = -2;
        lengthToAdd = 1;
        tail = new ArrayList<>();
        time = 0.0;
        tailLength = 0;
        running = false;
        if(info.getGameTheme() == 1)
        {
            if(id == 1)setImage("eggplantsnakep.jpg");
            else if(id == 2)setImage("eggplantsnakeg.jpg");
            else if(id == 3)setImage("eggplantsnakey.jpg");
            else if(id == 4)setImage("eggplantsnaker.jpg");
        }
        else if(info.getGameTheme() == 2)
        {
            if(id == 1)setImage("mario.jpg");
            else if(id == 2)setImage("luigi.jpg");
            else if(id == 3)setImage("wario.jpg");
            else if(id == 4)setImage("wal.jpg");
        }
        else if(info.getGameTheme() == 3)
        {
            if(id == 1)setImage("luke.jpg");
            else if(id == 2)setImage("darth.jpg");
            else if(id == 3)setImage("black.jpg");
            else if(id == 4)setImage("yoda.jpg");
        }


        t = new Timer(Integer.MAX_VALUE);

        setUpControl(Keyboard.KEY_W);
        setDownControl(Keyboard.KEY_S);
        setLeftControl(Keyboard.KEY_A);
        setRightControl(Keyboard.KEY_D);
    }

    public List<SnakeTail> getTail() {
        return tail;
    }

    public void setControls(int up, int down, int left, int right ){
        setUpControl(up);
        setDownControl(down);
        setLeftControl(left);
        setRightControl(right);
    }
    public void setUpControl(int keyboard){
        upControl = keyboard;
    }
    public void setDownControl(int keyboard){
        downControl = keyboard;
    }
    public void setLeftControl(int keyboard){
        leftControl = keyboard;
    }
    public void setRightControl(int keyboard){
        rightControl = keyboard;
    }
    public int getId(){
        return id;
    }
    public SnakeActor setWorld(World w){
        myWorld = w;
        return this;
    }
    public World getMyWorld(){
        return myWorld;
    }
    public void setTronMode(boolean mode){
        tronMode = mode;
    }

    /**
        Method: checkForPointChange
        Checks to see if any buttons are being pressed that would change how many points
        the snake gets on eating a peach
     */
    protected void checkForPointChange() {
        if (Mayflower.isKeyPressed(Keyboard.KEY_ADD)) {

            if (Mayflower.isKeyDown(Keyboard.KEY_LSHIFT) || Mayflower.isKeyDown(Keyboard.KEY_RSHIFT)) {
                System.out.println("Shifted");
                lengthToAdd += 10;
            } else if (Mayflower.isKeyDown(Keyboard.KEY_LCONTROL) || Mayflower.isKeyDown(Keyboard.KEY_RCONTROL)) {
                lengthToAdd += 1500;
            } else
                lengthToAdd++;
        }
        if (Mayflower.isKeyPressed(Keyboard.KEY_EQUALS)) {
            if (Mayflower.isKeyDown(Keyboard.KEY_LSHIFT) || Mayflower.isKeyDown(Keyboard.KEY_RSHIFT)) {
                if (Mayflower.isKeyDown(Keyboard.KEY_LCONTROL) || Mayflower.isKeyDown(Keyboard.KEY_RCONTROL)) {
                    lengthToAdd += 1500;
                } else
                    lengthToAdd += 10;
            }
        }
        if (Mayflower.isKeyPressed(Keyboard.KEY_SUBTRACT) || Mayflower.isKeyPressed(Keyboard.KEY_MINUS)) {

            if (Mayflower.isKeyDown(Keyboard.KEY_LSHIFT) || Mayflower.isKeyDown(Keyboard.KEY_RSHIFT)) {
                System.out.println("Shifted");
                lengthToAdd -= 10;
            } else if (Mayflower.isKeyDown(Keyboard.KEY_LCONTROL) || Mayflower.isKeyDown(Keyboard.KEY_RCONTROL)) {
                lengthToAdd -= 1500;
            } else
                lengthToAdd--;
        }

        if (t.isDone()) {
            if (tronMode)
                tailLength++;
            int trueTime = (int) (System.currentTimeMillis() - timeLastUpdate);
            int diff = trueTime - tickLen;
            tickLen = TICK_TIME - diff;
            sumTimes += trueTime;
            numTicks++;
            t.set(TICK_TIME - diff);
        }
    }
    public void act(){
        if(getWorld() != null)
            myWorld = getWorld();
        //Check to see if we should start counting realtime yet
        //If we dont do this, it causes a mad dash at the beginning of the game based on how long you wait to press a button
        if(timeLastUpdate == -1){
            timeLastUpdate = System.currentTimeMillis();
            t.reset();
        }
        checkForPointChange();

            if (isTouching(wall.class) || isTouching(SnakeTail.class) || isTouching(SnakeActor.class)) {
                myWorld = getWorld();
                if (isTouching(SnakeActor.class)) {
                    List<SnakeActor> others = getIntersectingObjects(SnakeActor.class);
                    for (SnakeActor a : others) {
                        myWorld.removeObject(a);
                        a.removeTail();
                    }
                    myWorld.removeObject(this);
                    removeTail();
                } else {
                    myWorld.removeObject(this);
                    removeTail();
                }
            }


    }

    public void turnLeft()
    {
        setRotation(Direction.WEST);
    }

    public void turnRight()
    {
        setRotation(Direction.EAST);
    }

    public void turnUp()
    {
        setRotation(Direction.NORTH);
    }

    public void turnDown()
    {
        setRotation(Direction.SOUTH);
    }

    public void tick()
    {
        int headX = getX();
        int headY = getY();
        int headRot = getRotation();
        bigify();
        moveSnake();
        if(Math.abs(getRotation()-headRot) % 180 == 0 && tailLength >= 2)
            setRotation(headRot);
        time++;
        //System.out.println(t.toString());
        move(20);
        handleTail(headX, headY, headRot);
        eatPeach(detectPeach());
    }

    public void die()
    {
        myWorld.removeObject(this);
    }

    public void grow()
    {
        if(tailLength > tail.size()){
            SnakeTail t = new SnakeTail(id, info);
            tail.add(t);
            getWorld().addObject(t,getX(),getY());
        }
    }

    public void collect()
    {
        eatPeach(getWorld().getObjects(Peach.class).get(0));

    }

    public void increaseScore()
    {
        score++;
    }

    public int getScore()
    {
        return score;
    }

    public void teleport(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public void removeTail(){
        for(SnakeTail t : tail){
            myWorld.removeObject(t);
        }
    }

    /**
     * moveSnake()
     * Determines if there has been any change in the direction of the snake, and
     * if so, it changes the direction of the snake to reflect this change
     */
    protected void moveSnake(){
        if (Mayflower.isKeyDown(upControl)) {
            setRotation(Direction.NORTH);
        } else if (Mayflower.isKeyDown(downControl)) {
            setRotation(Direction.SOUTH);
        } else if (Mayflower.isKeyDown(leftControl)) {
            setRotation(Direction.WEST);
        } else if (Mayflower.isKeyDown(rightControl)) {
            setRotation(Direction.EAST);
        }
    }
    public void saveScore(String initials){
        try
        {
            File scoreFile = new File("scores.txt");
            File nameFile = new File("names.txt");
            FileWriter scoreWriter = new FileWriter(scoreFile, true);
            FileWriter nameWriter = new FileWriter(nameFile, true);
            scoreWriter.write("\r\n");
            scoreWriter.write(Integer.toString(getTailLength()));
            scoreWriter.close();
            nameWriter.write("\r\n");
            nameWriter.write(initials);
            nameWriter.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();

        }
    }

    public double getTime(){
        double ntime = (time*75)/1000;
        return ntime;
    }
    public String getRatio(){

        double d = (double)(getTailLength()/getTime());
        System.out.println("Ratio: "+d+"Length: "+getTailLength()+" Time: "+getTime());
        return String.format("%.3f", d);

    }
    public void handleTail(int headX, int headY, int headRot){
        int prevX = headX;
        int prevY = headY;
        int prevRot = headRot;
        for(SnakeTail t : tail){
            int tempX = t.getX();
            int tempY = t.getY();
            int tempRot = t.getRotation();
            t.setLocation(prevX, prevY);
            t.setRotation(prevRot);
            prevX = tempX;
            prevY = tempY;
            prevRot = tempRot;
        }
        

    }
    public Peach detectPeach(){
        if(getIntersectingObjects(Peach.class).size() > 0){
            return getIntersectingObjects(Peach.class).get(0);
        }
        return null;
    }
    public void eatPeach(@Nullable Peach peach){
        if(peach == null){
        //    System.out.println("Peach is null");
            return;
        }
        getWorld().removeObject(peach);
        tailLength += lengthToAdd;
        Peach.addRandomPeach((peachStage)getWorld()); //Should never throw invalid cast errors
    }
    public void bigify(){
        if(tailLength > tail.size()){
            SnakeTail t = new SnakeTail(id, info);
            tail.add(t);
            getWorld().addObject(t,getX(),getY());
        }
    }
    public int getTailLength()
    {
        return tail.size();
    }
    public void startTimer()
    {
        t.set(75);
        timeLastUpdate = -1;
        running = true;
    }
    public boolean isPressing()
    {
        if(Mayflower.isKeyDown(upControl) || Mayflower.isKeyDown(downControl) || Mayflower.isKeyDown(leftControl) || Mayflower.isKeyDown(rightControl)){
            return true;
        }
        else {return false;}
    }
    public boolean getRunning()
    {
        return running;
    }
    public boolean getTronMode(){return tronMode;}
    class SnakeTail extends Actor{
        GameInfo info;
        int id;
        public SnakeTail(int id, GameInfo info){
            this.info = info;
            this.id = id;
            if(info.getGameTheme() == 1)
            {
                if(id == 1)setImage("eggplantsnakep.jpg");
                else if(id == 2)setImage("eggplantsnakeg.jpg");
                else if(id == 3)setImage("eggplantsnakey.jpg");
                else if(id == 4)setImage("eggplantsnaker.jpg");
            }
            else if(info.getGameTheme() == 2)
            {
                if(id == 1)setImage("mario.jpg");
                else if(id == 2)setImage("luigi.jpg");
                else if(id == 3)setImage("wario.jpg");
                else if(id == 4)setImage("wal.jpg");
            }
            else if(info.getGameTheme() == 3)
            {
                if(id == 1)setImage("luke.jpg");
                else if(id == 2)setImage("darth.jpg");
                else if(id == 3)setImage("black.jpg");
                else if(id == 4)setImage("yoda.jpg");
            }
        }
        @Override
        public void act(){
        }
        public String toString(){
            return "(X: "+getX()+", Y: "+getY()+")";
        }
    }

}