package tictactoeai.AI.tools;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tictactoeai.AI.SpaceRank;
import tictactoeai.board.GridValues;

/**
 *
 * @author Liekkipipo-pc
 */
public class BoardScannerTest {
    
    public BoardScannerTest() {
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
     * Test of scan method, of class BoardScanner.
     */
    @Test
    public void testScan() {
        System.out.println("scan");
        int x = 0;
        int y = 0;
        GridValues grid = null;
        short mark = 0;
        SpaceRank expResult = null;
        SpaceRank result = BoardScanner.scan(x, y, grid, mark);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of horizontalScan method, of class BoardScanner.
     */
    @Test
    public void testHorizontalScan() {
        System.out.println("horizontalScan");
        SpaceRank sr = null;
        GridValues grid = null;
        short mark = 0;
        BoardScanner.horizontalScan(sr, grid, mark);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verticalScan method, of class BoardScanner.
     */
    @Test
    public void testVerticalScan() {
        System.out.println("verticalScan");
        SpaceRank sr = null;
        GridValues grid = null;
        short mark = 0;
        BoardScanner.verticalScan(sr, grid, mark);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of diagonalRightLeftScan method, of class BoardScanner.
     */
    @Test
    public void testDiagonalRightLeftScan() {
        System.out.println("diagonalRightLeftScan");
        SpaceRank sr = null;
        GridValues grid = null;
        short mark = 0;
        BoardScanner.diagonalRightLeftScan(sr, grid, mark);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of diagonalLeftRightScan method, of class BoardScanner.
     */
    @Test
    public void testDiagonalLeftRightScan() {
        System.out.println("diagonalLeftRightScan");
        SpaceRank sr = null;
        GridValues grid = null;
        short mark = 0;
        BoardScanner.diagonalLeftRightScan(sr, grid, mark);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
