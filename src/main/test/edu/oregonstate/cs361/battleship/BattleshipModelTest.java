package edu.oregonstate.cs361.battleship;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Yingshi on 2/4/2017.
 */

public class BattleshipModelTest {
    @Test
    public void Test_userHit_or_Miss(){
        BattleshipModel Model = new BattleshipModel();
        String Hit = "you have hit the enemies ship, fire away";
        String Miss = "You have missed your shot, fire in new location";
        location Missing = new location(3,4);
        location Hitting = new location(2,2);
        location HittingEnd = new location(2,7);
        ships computer_aircraftCarrier = new ships("Computer_AircraftCarrier", 5, new location(2,2), new location(2,7));

        boolean ComA = Model.getComputer_aircraftCarrier().checkIfHit(Missing,computer_aircraftCarrier);
        assertEquals(false,ComA);


        boolean ComA_T = Model.getComputer_aircraftCarrier().checkIfHit(Hitting,computer_aircraftCarrier);
        assertEquals(true,ComA_T);

        boolean ComA_T_S = Model.getComputer_aircraftCarrier().checkIfHit(HittingEnd,computer_aircraftCarrier);
        assertEquals(true,ComA_T_S);


        String ResultHit = Model.userHitsOrMisses(Hitting);
        String ResultMissed = Model.userHitsOrMisses(Missing);
        assertEquals(ResultHit,Hit);



    }
    @Test
    public void Test_userHit_or_Miss_Battleship(){
        BattleshipModel Model = new BattleshipModel();
        String Hit = "you have hit the enemies ship, fire away";
        String Miss = "You have missed your shot, fire in new location";
        location Missing = new location(3,4);
        location Hitting = new location(2,8);
        location HittingEnd = new location(6,8);
        ships computer_battleship = new ships("Computer_Battleship", 4, new location(2,8), new location(6,8));

        boolean ComB = Model.getComputer_battleship().checkIfHit(Missing,computer_battleship);
        assertEquals(false,ComB);


        boolean ComB_T = Model.getComputer_battleship().checkIfHit(Hitting,computer_battleship);
        assertEquals(true,ComB_T);

        boolean ComB_T_S = Model.getComputer_battleship().checkIfHit(HittingEnd,computer_battleship);
        assertEquals(true,ComB_T_S);


        String ResultHit = Model.userHitsOrMisses(Hitting);
        String ResultMissed = Model.userHitsOrMisses(Missing);
        assertEquals(ResultHit,Hit);



    }
    @Test
    //computer_cruiser = new ships("Computer_Cruiser", 3, new location(4,1), new location(4,4));

    public void Test_userHit_or_Miss_cruiser(){
        BattleshipModel Model = new BattleshipModel();
        String Hit = "you have hit the enemies ship, fire away";
        String Miss = "You have missed your shot, fire in new location";
        location Missing = new location(3,4);
        location Hitting = new location(4,1);
        location HittingEnd = new location(4,4);
        ships computer_cruiser = new ships("Computer_Cruiser", 3, new location(4,1), new location(4,4));

        boolean ComC = Model.getComputer_cruiser().checkIfHit(Missing,computer_cruiser);
        assertEquals(false,ComC);


        boolean ComC_T = Model.getComputer_cruiser().checkIfHit(Hitting,computer_cruiser);
        assertEquals(true,ComC_T);

        boolean ComC_T_S = Model.getComputer_cruiser().checkIfHit(HittingEnd,computer_cruiser);
        assertEquals(true,ComC_T_S);


        String ResultHit = Model.userHitsOrMisses(Hitting);
        String ResultMissed = Model.userHitsOrMisses(Missing);
        assertEquals(ResultHit,Hit);



    }
    @Test
    //computer_destroyer = new ships("Computer_Destroyer", 2, new location(7,3), new location(7,5));

    public void Test_userHit_or_Miss_destroyer(){
        BattleshipModel Model = new BattleshipModel();
        String Hit = "you have hit the enemies ship, fire away";
        String Miss = "You have missed your shot, fire in new location";
        location Missing = new location(3,4);
        location Hitting = new location(7,3);
        location HittingEnd = new location(7,5);
        ships computer_destroyer = new ships("Computer_Destroyer", 2, new location(7,3), new location(7,5));

        boolean ComD = Model.getComputer_destroyer().checkIfHit(Missing,computer_destroyer);
        assertEquals(false,ComD);


        boolean ComD_T = Model.getComputer_destroyer().checkIfHit(Hitting,computer_destroyer);
        assertEquals(true,ComD_T);

        boolean ComD_T_S = Model.getComputer_destroyer().checkIfHit(HittingEnd,computer_destroyer);
        assertEquals(true,ComD_T_S);


        String ResultHit = Model.userHitsOrMisses(Hitting);
        String ResultMissed = Model.userHitsOrMisses(Missing);
        assertEquals(ResultHit,Hit);



    }
    @Test
    //computer_submarine = new ships("Computer_Submarine", 2, new location(9,6), new location(9,8));

    public void Test_userHit_or_Miss_submarine(){
        BattleshipModel Model = new BattleshipModel();
        String Hit = "you have hit the enemies ship, fire away";
        String Miss = "You have missed your shot, fire in new location";
        location Missing = new location(3,4);
        location Hitting = new location(9,6);
        location HittingEnd = new location(9,8);
        ships computer_submarine = new ships("Computer_Submarine", 2, new location(9,6), new location(9,8));

        boolean ComS = Model.getComputer_submarine().checkIfHit(Missing,computer_submarine);
        assertEquals(false,ComS);


        boolean ComS_T = Model.getComputer_submarine().checkIfHit(Hitting,computer_submarine);
        assertEquals(true,ComS_T);

        boolean ComS_T_S = Model.getComputer_submarine().checkIfHit(HittingEnd,computer_submarine);
        assertEquals(true,ComS_T_S);


        String ResultHit = Model.userHitsOrMisses(Hitting);
        String ResultMissed = Model.userHitsOrMisses(Missing);
        assertEquals(ResultHit,Hit);



    }
    @Test
    //aircraftCarrier = new ships("AircraftCarrier", 5, new location(0,0), new location(0,0));

    public void Test_Com_Hit_or_Miss_aircraftCarrier(){
        BattleshipModel Model = new BattleshipModel();
        String Hit = "you have hit the enemies ship, fire away";
        String Miss = "You have missed your shot, fire in new location";
        location Missing = new location(3,2);
        location Hitting = new location(1,4);
        location HittingEnd = new location(6,4);
        ships aircraftCarrier= new ships("AircraftCarrier", 5, new location(1,4), new location(6,4));
        Model.setAircraftCarrier(aircraftCarrier);
        boolean ComA = Model.getaircraftCarrier().checkIfHit(Missing,aircraftCarrier);
        assertEquals(false,ComA);


        boolean ComA_T = Model.getaircraftCarrier().checkIfHit(Hitting, aircraftCarrier);
        assertEquals(true,ComA_T);


        String ResultHit = Model.computerHitsOrMisses(Hitting);
        String ResultMissed = Model.computerHitsOrMisses(Missing);
        assertEquals(ResultHit,Hit);
        assertEquals(ResultMissed,Miss);



    }
    @Test
    public void Test_Com_Hit_or_Miss_battleshipModel(){
        BattleshipModel Model = new BattleshipModel();
        String Hit = "you have hit the enemies ship, fire away";
        String Miss = "You have missed your shot, fire in new location";
        location Missing = new location(3,2);
        location Hitting = new location(1,4);
        ships battleship = new ships("Battleship", 4, new location(1,4), new location(1,5));

        Model.setBattleship(battleship);
        boolean ComB = Model.getbattleship().checkIfHit(Missing,battleship);
        assertEquals(false,ComB);

        boolean ComB_T = Model.getbattleship().checkIfHit(Hitting, battleship);
        assertEquals(true,ComB_T);


        String ResultHit = Model.computerHitsOrMisses(Hitting);
        String ResultMissed = Model.computerHitsOrMisses(Missing);
        assertEquals(ResultHit,Hit);
        assertEquals(ResultMissed,Miss);



    }
    @Test
    public void Test_Com_Hit_or_Miss_cruiser(){
        BattleshipModel Model = new BattleshipModel();
        String Hit = "you have hit the enemies ship, fire away";
        String Miss = "You have missed your shot, fire in new location";
        location Missing = new location(3,2);
        location Hitting = new location(1,4);
        ships cruiser = new ships("Cruiser", 3, new location (1,4), new location(4,4));

        Model.setCruiser(cruiser);
        boolean ComB = Model.getcruiser().checkIfHit(Missing,cruiser);
        assertEquals(false,ComB);

        boolean ComB_T = Model.getcruiser().checkIfHit(Hitting, cruiser);
        assertEquals(true,ComB_T);


        String ResultHit = Model.computerHitsOrMisses(Hitting);
        String ResultMissed = Model.computerHitsOrMisses(Missing);
        assertEquals(ResultHit,Hit);
        assertEquals(ResultMissed,Miss);



    }
    @Test
    public void Test_Com_Hit_or_Miss_destroyer(){
        BattleshipModel Model = new BattleshipModel();
        String Hit = "you have hit the enemies ship, fire away";
        String Miss = "You have missed your shot, fire in new location";
        location Missing = new location(3,2);
        location Hitting = new location(1,4);
        ships destroyer = new ships("Destroyer", 2, new location(1,4), new location(3,4));

        Model.setDestroyer(destroyer);
        boolean ComB = Model.getdestroyer().checkIfHit(Missing,destroyer);
        assertEquals(false,ComB);

        boolean ComB_T = Model.getdestroyer().checkIfHit(Hitting, destroyer);
        assertEquals(true,ComB_T);


        String ResultHit = Model.computerHitsOrMisses(Hitting);
        String ResultMissed = Model.computerHitsOrMisses(Missing);
        assertEquals(ResultHit,Hit);
        assertEquals(ResultMissed,Miss);



    }
    @Test
    public void Test_Com_Hit_or_Miss_submarine(){
        BattleshipModel Model = new BattleshipModel();
        String Hit = "you have hit the enemies ship, fire away";
        String Miss = "You have missed your shot, fire in new location";
        location Missing = new location(3,2);
        location Hitting = new location(1,4);
        ships submarine = new ships("Submarine", 2, new location(1,4), new location(1,6));

        Model.setSubmarine(submarine);
        boolean ComB = Model.getsubmarine().checkIfHit(Missing,submarine);
        assertEquals(false,ComB);

        boolean ComB_T = Model.getsubmarine().checkIfHit(Hitting, submarine);
        assertEquals(true,ComB_T);


        String ResultHit = Model.computerHitsOrMisses(Hitting);
        String ResultMissed = Model.computerHitsOrMisses(Missing);
        assertEquals(ResultHit,Hit);
        assertEquals(ResultMissed,Miss);



    }


}
