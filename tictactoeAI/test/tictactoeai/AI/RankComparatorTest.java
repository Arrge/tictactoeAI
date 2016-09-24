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
public class RankComparatorTest {
    
    SpaceRank x,y;
    
    public RankComparatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        x = new SpaceRank(10, 10);
        y = new SpaceRank(14, 10);
        x.rank = 666;
        y.rank = 333;
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of compare method, of class RankComparator.
     */
    @Test
    public void testCompareRank() {
        System.out.println("compare");
        x.rank = 1;
        y.rank = 0;
        
        RankComparator instance = new RankComparator();
        int expResult = -1;
        int result = instance.compare(x, y);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of compare method, of class RankComparator.
     */
    @Test
    public void testCompareForcedMoveToWinningMove() {
        System.out.println("compare");
        x.forcedMove = 1;
        y.winningMove = 1;
        y.enemyWinningMove = 1;
        RankComparator instance = new RankComparator();
        int expResult = -1;
        int result = instance.compare(x, y);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of compare method, of class RankComparator.
     */
    @Test
    public void testCompareWinningMoveToEnemyWinningMove() {
        System.out.println("compare");
        x.winningMove = 1;
        y.enemyWinningMove = 1;
        RankComparator instance = new RankComparator();
        int expResult = -1;
        int result = instance.compare(x, y);
        assertEquals(expResult, result);
    }
    
    
}
