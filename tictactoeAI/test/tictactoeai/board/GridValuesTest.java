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
        short mark = 0;
        GridValues instance = null;
        boolean expResult = false;
        boolean result = instance.setSpace(x, y, mark);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class GridValues.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        int x = 0;
        int y = 0;
        GridValues instance = null;
        boolean expResult = false;
        boolean result = instance.isEmpty(x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMark method, of class GridValues.
     */
    @Test
    public void testGetMark() {
        System.out.println("getMark");
        int x = 0;
        int y = 0;
        GridValues instance = null;
        short expResult = 0;
        short result = instance.getMark(x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSideLength method, of class GridValues.
     */
    @Test
    public void testGetSideLength() {
        System.out.println("getSideLength");
        GridValues instance = null;
        int expResult = 0;
        int result = instance.getSideLength();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGrid method, of class GridValues.
     */
    @Test
    public void testGetGrid() {
        System.out.println("getGrid");
        GridValues instance = null;
        short[][] expResult = null;
        short[][] result = instance.getGrid();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
