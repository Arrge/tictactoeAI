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
public class SpaceRankTest {
    
    public SpaceRankTest() {
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
     * Test of setOpenSidesAndConsecutives method, of class SpaceRank.
     */
    @Test
    public void testSetOpenSidesAndConsecutives() {
        System.out.println("setOpenSidesAndConsecutives");
        int openSides = 2;
        int consecutives = 3;
        SpaceRank instance = new SpaceRank(0, 0);
        instance.setOpenSidesAndConsecutives(openSides, consecutives);
        assertEquals(1, instance.index);
        assertEquals(openSides, instance.openSides[0]);
        assertEquals(consecutives, instance.consecutives[0]);
        
    }

    /**
     * Test of calculateRank method, of class SpaceRank.
     */
    @Test
    public void testCalculateRank() {
        System.out.println("calculateRank");
         int openSides = 2;
        int consecutives = 3;
        SpaceRank instance = new SpaceRank(0, 0);
        instance.setOpenSidesAndConsecutives(openSides, consecutives);
        boolean expResult = false;
        boolean result = instance.calculateRank();
        assertEquals(expResult, result);
        assertEquals(4, instance.rank);
    }

    /**
     * Test of calculateOpponentsRank method, of class SpaceRank.
     */
    @Test
    public void testCalculateOpponentsRank() {
        System.out.println("calculateOpponentsRank");
        SpaceRank instance = null;
        instance.calculateOpponentsRank();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getX method, of class SpaceRank.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        SpaceRank instance = null;
        int expResult = 0;
        int result = instance.getX();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getY method, of class SpaceRank.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        SpaceRank instance = null;
        int expResult = 0;
        int result = instance.getY();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRank method, of class SpaceRank.
     */
    @Test
    public void testGetRank() {
        System.out.println("getRank");
        SpaceRank instance = null;
        int expResult = 0;
        int result = instance.getRank();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOpponentsRank method, of class SpaceRank.
     */
    @Test
    public void testGetOpponentsRank() {
        System.out.println("getOpponentsRank");
        SpaceRank instance = null;
        int expResult = 0;
        int result = instance.getOpponentsRank();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotalRank method, of class SpaceRank.
     */
    @Test
    public void testGetTotalRank() {
        System.out.println("getTotalRank");
        SpaceRank instance = null;
        int expResult = 0;
        int result = instance.getTotalRank();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isForcedMove method, of class SpaceRank.
     */
    @Test
    public void testIsForcedMove() {
        System.out.println("isForcedMove");
        SpaceRank instance = null;
        int expResult = 0;
        int result = instance.isForcedMove();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isWinningMove method, of class SpaceRank.
     */
    @Test
    public void testIsWinningMove() {
        System.out.println("isWinningMove");
        SpaceRank instance = null;
        int expResult = 0;
        int result = instance.isWinningMove();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEnemyWinningMove method, of class SpaceRank.
     */
    @Test
    public void testIsEnemyWinningMove() {
        System.out.println("isEnemyWinningMove");
        SpaceRank instance = null;
        int expResult = 0;
        int result = instance.isEnemyWinningMove();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
