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
    //public location(){
    //    Across = 0;
    //    Down = 0;
    //}

    //if we are given location and the arguments for across and down
    public location(int x, int y){
        this.Across = x;
        this.Down = y;
    }

    //in case we have a json file and we want to copy it.
    public location(location copymebaby){
        Across = copymebaby.Across;
        Down = copymebaby.Down;
    }

}
