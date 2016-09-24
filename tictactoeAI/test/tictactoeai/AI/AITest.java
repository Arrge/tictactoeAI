package tictactoeai.AI;

import java.awt.Point;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tictactoeai.board.GridValues;

/**
 *
 * @author Liekkipipo-pc
 */
public class AITest {
    
    public AITest() {
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
     * Test of getMove method, of class AI.
     */
    @Test
    public void testGetMove() {
        System.out.println("getMove");
        GridValues grid = null;
        AI instance = null;
        Point expResult = null;
        Point result = instance.getMove(grid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMark method, of class AI.
     */
    @Test
    public void testGetMark() {
        System.out.println("getMark");
        AI instance = null;
        short expResult = 0;
        short result = instance.getMark();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
