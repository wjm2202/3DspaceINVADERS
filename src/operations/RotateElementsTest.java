package operations;

import gameValues.Movement;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Inderjit Janjua on 12/10/2016.
 */
public class RotateElementsTest {

    /**
     * This test is used to tell me if the enumeration values being compared are the same.
     *
     * The test returns true if the enums comapred have the same values
     *
     * @throws Exception
     */
    @Test
    public void rotateTank() throws Exception {

        Movement forwardFacing = Movement.forwards;         //Tank is facing forwards
        Movement backwardFacing = Movement.backwards;       //Tank is facing backwards
        Movement rightFacing = Movement.left;               //Tank is facing left
        Movement leftFacing = Movement.right;               //Tank is facing right

        if(forwardFacing == Movement.forwards){     //returns true if the values are the same
            assertTrue(true);
        }
        else if(backwardFacing == Movement.backwards){  //returns true if the values are the same
            assertTrue(true);
        }
        else if(rightFacing == Movement.right){     //returns true if the values are the same
            assertTrue(true);
        }
        else if(leftFacing == Movement.left){       //returns true if the values are the same
            assertTrue(true);
        }
        else{
            assertTrue(false);      //returns false if the values of the enums are not the same
        }

    }

}