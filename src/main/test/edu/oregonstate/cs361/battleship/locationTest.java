package edu.oregonstate.cs361.battleship;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Yingshi on 2/4/2017.
 */
public class locationTest {

    @Test
    public void  Test_location() {
        location loc1 = new location(1,2);
        int AcrossValue = loc1.getAcross();
        int DownValue = loc1.getDown();
        assertEquals(AcrossValue,1);
        assertEquals(DownValue, 2);

    }
    @Test
    public void  Test_empty() {
        location empty = new location();
        int AcrossValue = empty.getAcross();
        int DownValue = empty.getDown();
        assertEquals(AcrossValue,0);
        assertEquals(DownValue, 0);

    }
    @Test
    public void  Test_copy_location() {
        location origin = new location(1,2);
        location copy = new location(origin);
        int AcrossValue = copy.getAcross();
        int DownValue = copy.getDown();
        assertEquals(AcrossValue,1);
        assertEquals(DownValue, 2);

    }
    @Test
    public void Test_verticalLength(){
        location pass = new location(1,3);
        location compare = new location(3,6);
        location sec = new location(8,0);
        int Value = sec.getDown();
        int DownValue = compare.getDown();
        int vertical = compare.verticalLength(pass);
        int verticalsec = sec.verticalLength(pass);
        assertEquals(verticalsec,3);
        assertEquals(vertical,3);
    }
    @Test
    public void Test_horizontalLength(){
        location passing = new location(2,3);
        location comparing = new location(3,6);
        location sec = new location(1,3);
        int AcrossV = sec.getAcross();
        int AcrossValue = comparing.getAcross();
        int horizontalSec = sec.horizontalLength(passing);
        int horizontal = comparing.horizontalLength(passing);
        assertEquals(horizontal,1);
        assertEquals(horizontalSec,1);
    }
    @Test
    public void Test_setLocation(){
        location boat = new location();
        boat.setLocation(3,4);
        int AcrossV = boat.getAcross();
        assertEquals(AcrossV,4);
    }

}