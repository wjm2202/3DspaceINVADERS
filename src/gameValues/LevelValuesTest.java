package gameValues;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Liandri on 4/10/2016.
 */
public class LevelValuesTest {


    @Test
    public void levelChange() throws Exception {
        double changeValue = 0.2;
        LevelValues lv = new LevelValues();
        assertTrue(lv.getDropsPerSecond() == 30);
        assertTrue(lv.getEnemyBombDamage() == 20);
        assertTrue(lv.getEnemyBombSpeed() == 5);
        assertTrue(lv.getXvelocity() == 5.0);
        assertTrue(lv.getYvelocity() == 0.0);
        assertTrue(lv.getXvelocity() == 5.0);
        assertTrue(lv.getSpinDrop() == 1.0);
        lv.levelUP(changeValue);
        assertTrue(lv.getDropsPerSecond() == 29);
        assertTrue(lv.getEnemyBombDamage() == 21);
        assertTrue(lv.getEnemyBombSpeed() == 6);
        assertTrue(lv.getXvelocity() == 5.2);
        assertTrue(lv.getYvelocity() == 0.0);
        assertTrue(lv.getZvelocity() == 5.2);
        assertTrue(lv.getSpinDrop() == 1.2);

    }
}