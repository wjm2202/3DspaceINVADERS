package database;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Liandri on 5/10/2016.
 */
public class NameTest {
    @Before
    public void setUp() throws Exception {
        Name playerName = new Name();
        playerName.setNickname("shadowtheHedgehog");
        playerName.setEmail("shadowsega95@hotmail.com");
        assertTrue(playerName.getNickname().equals("shadowtheHedgehog"));
        assertTrue(playerName.getEmail().equals("shadowsega95@hotmail.com"));
    }

    @After
    public void tearDown() throws Exception {
        Name playerName = new Name();
        playerName.setNickname("");
        playerName.setEmail("");
        assertFalse(playerName.getNickname().equals("shadowtheHedgehog"));
        assertFalse(playerName.getEmail().equals("shadowsega95@hotmail.com"));
    }

    @Test
    public void getNickname() throws Exception {
        //assertTrue(true);
        Name playerName = new Name("SonicChaos12", "");
        assertEquals(playerName.getNickname(), "SonicChaos12");
    }


    @Test
    public void getEmail() throws Exception {
        Name playername = new Name();
        playername.setEmail("ericlam95@gmail.com");
        assertEquals("ericlam95@gmail.com", playername.getEmail());
    }


    @Test
    public void maketable() throws Exception {
        Name playername = new Name();
        assertTrue(playername.maketable());
    }

}