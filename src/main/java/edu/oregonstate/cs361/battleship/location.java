package edu.oregonstate.cs361.battleship;

/**
 * Created by River Hendriksen on 1/30/17.
 * After trials and fustration I realized that in order for start and end to look pretty there must be an object for them.
 * does that make sense? probably not, but no one really needs to edit this beside me. all this does is order the lists for start and
 * end so they fit the model that was given as an example.
 */
public class location {

    private int Across;
    private int Down;

    //I thought this was would be used as an initializer but that never needed to be done
    public location(){
       Across = 0;
       Down = 0;
    }

    //if we are given location and the arguments for x = across and y = down
    public location(int x, int y){
        this.Across = x;
        this.Down = y;
    }

    //in case we have a json file and we want to copy it.
    public location(location copymebaby){
        Across = copymebaby.Across;
        Down = copymebaby.Down;
    }

    //in case we need to access it out side the class
    public int getAcross(){
        return Across;
    }

    public int getDown()
    {
        return Down;
    }
    //to check the vertical length of the board
    public int verticalLength(location point)
    {
       int sendingLength;
        if(point.Down >= Down)
        {
            sendingLength = point.Down - Down;
        }
        else {
            sendingLength = Down - point.Down;
        }
        return sendingLength;
    }

    //to check the horizontal length of the board
    public int horizontalLength(location point)
    {
        int sendingLength;
            if(point.Across >= Across) {
                sendingLength = point.Across - Across;
            } else {
                sendingLength = Across - point.Across;
            }
        return sendingLength;
    }

    //sets the location of the point you want.
   public void setLocation(int horizontal, int vertical)
    {
        Across = horizontal;
        Across = vertical;
    }
}



