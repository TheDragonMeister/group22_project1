package edu.oregonstate.cs361.battleship;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.google.gson.*;
/**
 * Created by Cade on 2/4/2017.
 */
public class shipsTest {
    //needed two objects to check over lap locations
    ships obj1;
    ships obj2;
    //test name check
    @Test
    public void nameCheckTest()
    {
        location check = new location(5,5);
        obj1 =new ships("destroyer",2,check,check);

        //check for both working and not working names
        boolean testString = obj1.nameCheck("destroyer");
        boolean testFalseString = obj1.nameCheck("DeathStar");
        assertEquals(true, testString);
    }
    // test checkIfHit
    @Test
    public void checkIfHitTest()
    {
        location check = new location(5,5);
        location falseCheck = new location(3,3);

        obj1= new ships("destroyer",2, check, check );
        obj2= new ships("destroyter", 2, falseCheck,falseCheck);

        boolean testShot = obj1.checkIfHit(check,obj1);
        boolean testMissShot = obj2.checkIfHit(check,obj2);

        assertEquals(true, testShot);
        assertEquals(false,testMissShot);

    }


    @Test
    void testSetStart(){

        location x = new location(5, 5);
        location zero = new location (0, 0);

       obj1 = new ships("tie-fighter", 4, x, zero);
        obj2 = new ships("tie-fighter", 4, zero, zero);

        obj2.setStartLocation(2, 2);

        assertEquals(obj1, obj2);
    }

    @Test
    void testSetEnd(){

        location x = new location(5, 5);
        location zero = new location (0, 0);

        obj1 = new ships("tie-fighter", 4, zero, x);
        obj2 = new ships("tie-fighter", 4, zero, zero);
        obj2.setEndLocation(2, 2);

        assertEquals(obj1, obj2);
    }
}
