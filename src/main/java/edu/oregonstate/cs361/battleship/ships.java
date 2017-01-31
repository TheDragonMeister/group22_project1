package edu.oregonstate.cs361.battleship;


/**
 * Created by River Hendriksen on 1/30/17.
 * This file is for the ship object which is a subset of the battleship model, This is separate from the battleship model \
 * as it is technically its own object (OO is confusing). This object is what defines where the ships on the board are located
 * and their length and name. For battleship there will always be 5 ships.
 */


public class ships {

    //values that must be held by all ships
    private String name;
    private int Length;
    private location start;
    private location end;

    //This is what the ship will be if there is nothing given to the ship intializer in the other files
    //basically it is all set to nothing but luckily we will always be setting the name and length to some values by the end
    //of battleshipmodel.
    public ships(){
        name = "";
        Length = 0;
        start = new location(0,0);
        end = new location(0,0);
    }

    //this is if the ship has variables that needed to be inputted by the other files. This is what will happen often.
    public ships(String name, int Length, location start, location end){
        this.name = name;
        this.Length = Length;
        this.start = new location(start);
        this.end = new location(end);
    }

    // This copies values from a previous ship to the new ships model, This may be helpful for makereq function that is after new 
    //model, I did not look too much into it though
    public ships(ships copymepapa){
        name = copymepapa.name;
        Length = copymepapa.Length;
        //gotta have those new otherwise there may be an operator overload not taking the chance bucko
        start = new location(copymepapa.start);
        end = new location(copymepapa.end);
    }

}
