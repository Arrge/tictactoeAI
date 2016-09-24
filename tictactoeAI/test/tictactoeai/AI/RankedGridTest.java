package tictactoeai.AI;

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
public class RankedGridTest {
    
    public RankedGridTest() {
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
     * Test of addSpaceRank method, of class RankedGrid.
     */
    @Test
    public void testAddSpaceRank() {
        System.out.println("addSpaceRank");
        SpaceRank sr = null;
        RankedGrid instance = null;
        instance.addSpaceRank(sr);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBestMove method, of class RankedGrid.
     */
    @Test
    public void testGetBestMove() {
        System.out.println("getBestMove");
        RankedGrid instance = null;
        SpaceRank expResult = null;
        SpaceRank result = instance.getBestMove();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
