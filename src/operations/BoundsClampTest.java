package operations;

import javafx.geometry.Point3D;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Inderjit Janjua on 5/10/2016.
 */
public class BoundsClampTest {

    /**
     * This method tests to see if the tank is in the box when moving left and right.
     *
     * When checking the bounds, we noticed the test passed
     * @throws Exception
     */
    @Test
    public void tankXClamp() throws Exception {
        Point3D tankLocation1 = new Point3D(-3, 500, 900);      //Outside the box to the left
        Point3D tankLocation2 = new Point3D(500, 500, 900);     //Inside the box
        Point3D tankLocation3 = new Point3D(1200, 500, 900);    //Outside the box to the right

        BoundsClamp bc = new BoundsClamp();                     //New BoundsClamp object for testing

        assertEquals(false ,bc.tankXClamp(tankLocation1));      //Outside the box, therefore test should return false
        assertEquals(true ,bc.tankXClamp(tankLocation2));       //Inside the box, therefore test should return true
        assertEquals(false ,bc.tankXClamp(tankLocation3));      //Outside the box, therefore test should return false

    }

    /**
     * This method tests to see if the tank is in the box when moving up and down.
     *
     * When checking the bounds, we noticed the test failed
     * @throws Exception
     */
    @Test
    public void tankZClamp() throws Exception {
        Point3D tankLocation1 = new Point3D(500, 500, 900);     //Outside the box beyond the player
        Point3D tankLocation2 = new Point3D(500, 1100, 900);    //Inside the box
        Point3D tankLocation3 = new Point3D(500, 1400, 900);    //Outside the box towards the player

        BoundsClamp bc = new BoundsClamp();                     //New BoundsClamp object for testing

        assertEquals(false ,bc.tankXClamp(tankLocation1));      //Outside the box, therefore test should return false
        assertEquals(true ,bc.tankXClamp(tankLocation2));       //Inside the box, therefore test should return true
        assertEquals(false ,bc.tankXClamp(tankLocation3));      //Outside the box, therefore test should return false
    }

}