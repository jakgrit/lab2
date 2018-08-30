import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OXTest {
    @Test
    void getTableString(){
        OX ox = new OX();
        assertEquals(" 012\n" +
                "0---\n" +
                "1---\n" +
                "2---\n", ox.getTableString());
    }

    @Test
    void getCurrentPlayer(){
        OX ox = new OX();
        assertEquals("X", ox.getCurrentPlayer());
    }

    @Test
    void switchPlayer(){
        OX ox = new OX();
        ox.switchPlayer();
        assertEquals("O", ox.getCurrentPlayer());
    }

    @Test
    void putAt0_0(){
        OX ox = new OX();
        ox.put(0,0);
        assertEquals(" 012\n" +
                "0X--\n" +
                "1---\n" +
                "2---\n", ox.getTableString());
    }

    @Test
    void putAt0_0Twice(){
        OX ox = new OX();
        assertTrue(ox.put(0,0));
        assertFalse(ox.put(0,0));
    }

    @Test
    void putOverTable(){
        OX ox = new OX();
        assertFalse(ox.put(0,-1));
        assertFalse(ox.put(0,3));
        assertFalse(ox.put(3,-1));
        assertFalse(ox.put(-1,3));
    }

    @Test
    void getAt0_0(){
        OX ox = new OX();
        ox.put(0,0);
        assertEquals(" 012\n" +
                "0X--\n" +
                "1---\n" +
                "2---\n", ox.getTableString());
        assertEquals("X", ox.get(0 , 0));
    }

    @Test
    void getOver(){
        OX ox = new OX();
        assertNull(null, ox.get(0,-1));
        assertNull(null, ox.get(0,3));
        assertNull(null, ox.get(3,-1));
        assertNull(null, ox.get(-1,3));
    }
}