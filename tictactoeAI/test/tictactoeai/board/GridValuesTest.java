package tictactoeai.board;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Liekkipipo-pc
 */
public class GridValuesTest {
    
    public GridValuesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setSpace method, of class GridValues.
     */
    @Test
    public void testSetSpace() {
        System.out.println("setSpace");
        int x = 0;
        int y = 0;
        short mark = 1;
        GridValues instance = new GridValues(15);
        instance.setSpace(x, y, mark);
        boolean expResult = false;
        boolean result = instance.isEmpty(x, y);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of isEmpty method, of class GridValues.
     */
    @Test
    public void testIsEmpty1() {
        System.out.println("isEmpty");
        int x = 0;
        int y = 0;
        GridValues instance = new GridValues(15);
        instance.setSpace(10, y, (short)1);
        boolean expResult = true;
        boolean result = instance.isEmpty(x, y);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of isEmpty method, of class GridValues.
     */
    @Test
    public void testIsEmpty2() {
        System.out.println("isEmpty");
        int x = 0;
        int y = 0;
        GridValues instance = new GridValues(15);
        instance.setSpace(x, y, (short)1);
        boolean expResult = false;
        boolean result = instance.isEmpty(x, y);
        assertEquals(expResult, result);
       
    }
}
