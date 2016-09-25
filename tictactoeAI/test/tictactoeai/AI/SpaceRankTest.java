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
        int openSides = 2;
        int consecutives = 3;
        SpaceRank instance = new SpaceRank(0, 0);
        instance.setOpenSidesAndConsecutives(openSides, consecutives);
        instance.setOpenSidesAndConsecutives(openSides, consecutives);
        instance.setOpenSidesAndConsecutives(openSides, consecutives);
        instance.setOpenSidesAndConsecutives(openSides, consecutives);
        instance.setOpenSidesAndConsecutives(openSides, consecutives);
        
        instance.calculateOpponentsRank();
        
        assertEquals(4, instance.opponentsRank);
    }
}
