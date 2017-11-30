package sample;

public class MultiStage extends peachStage{
    private int numPlay = 0;
    private SnakeActor snek2;
    private SnakeActor snek3;
    private SnakeActor snek4;

    public MultiStage(int numnum)
    {
        super();
        numPlay = numnum;
        if(numPlay == 1)
        {
            addObject(snek2, 740, 540);
        }
        else if(numPlay == 2)
        {
            addObject(snek2, 740, 540);
            addObject(snek3, 740, 40);
        }
        else if(numPlay == 3)
        {
            addObject(snek2, 740, 540);
            addObject(snek3, 740, 40);
            addObject(snek4, 40, 540);
        }
    }
}
