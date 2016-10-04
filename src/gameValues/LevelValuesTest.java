package gameValues;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Liandri on 4/10/2016.
 */
public class LevelValuesTest {

    @Test
    public void getDropsPerSecond() throws Exception {
        assertTrue(true);
    }
    @Test
    public void dropsIncrease() throws Exception {
        LevelValues lv = new LevelValues();
        assertTrue(lv.getDropsPerSecond()==30);
        lv.levelUP(0.2);
        assertTrue(lv.getDropsPerSecond()==28);
        assertTrue(true);
    }

}