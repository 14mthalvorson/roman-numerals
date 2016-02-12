package project1;

import static org.junit.Assert.*;

/**
 * Created by Martin on 2/11/2016.
 */
public class RomanNumeralTest {
    private RomanNumeral r1 = new RomanNumeral(143);
    private RomanNumeral r2 = new RomanNumeral(2304);

    @org.junit.Test
    public void testToString() throws Exception {
        assertEquals(r1.toString(), "CXLIII");
        assertEquals(r2.toString(), "MMCCCIV");
    }

    @org.junit.Test
    public void testToInt() throws Exception {
        assertEquals(r1.toInt(), 143);
        assertEquals(r2.toInt(), 2304);
    }

    @org.junit.Test
    public void testCompareTo() throws Exception {
        assertEquals(r1.compareTo(r2), -1);
        assertEquals(r2.compareTo(r1), 1);
        assertEquals(r1.compareTo(r1), 0);
    }
}