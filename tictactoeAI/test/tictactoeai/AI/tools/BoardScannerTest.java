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
    public void testScan1() {
        System.out.println("scan");
        int x = 0;
        int y = 0;
        GridValues grid = new GridValues(15);
        short mark = 1;
        grid.setSpace(1, y, mark);
        grid.setSpace(2, y, mark);
        grid.setSpace(3, y, mark);
        grid.setSpace(4, y, mark);
        SpaceRank result = BoardScanner.scan(x, y, grid, mark);
        assertEquals(true, result.calculateRank());
    }
    
    /**
     * Test of scan method, of class BoardScanner.
     */
    @Test
    public void testScan4() {
        System.out.println("scan");
        int x = 0;
        int y = 0;
        GridValues grid = new GridValues(15);
        short mark = 1;
        grid.setSpace(1, 1, mark);
        grid.setSpace(2, 2, mark);
        grid.setSpace(3, 3, mark);
        grid.setSpace(4, 4, mark);
        SpaceRank result = BoardScanner.scan(x, y, grid, mark);
        assertEquals(true, result.calculateRank());
    }
    
    /**
     * Test of scan method, of class BoardScanner.
     */
    @Test
    public void testScan2() {
        System.out.println("scan");
        int x = 0;
        int y = 0;
        GridValues grid = new GridValues(15);
        short mark = 1;
        grid.setSpace(1, y, mark);
        grid.setSpace(2, y, mark);
        grid.setSpace(3, y, mark);
        SpaceRank result = BoardScanner.scan(x, y, grid, mark);
        assertEquals(false, result.calculateRank());
        assertEquals(3, result.getRank());
    }
    /**
     * Test of scan method, of class BoardScanner.
     */
    @Test
    public void testScan3() {
        System.out.println("scan");
        int x = 5;
        int y = 0;
        GridValues grid = new GridValues(15);
        short mark = 1;
        grid.setSpace(2, y, mark);
        grid.setSpace(3, y, mark);
        grid.setSpace(4, y, mark);
        SpaceRank result = BoardScanner.scan(x, y, grid, mark);
        assertEquals(false, result.calculateRank());
        assertEquals(4, result.getRank());
    }
    /**
     * Test of scan method, of class BoardScanner.
     */
    @Test
    public void testScan5() {
        System.out.println("scan");
        int x = 5;
        int y = 5;
        GridValues grid = new GridValues(15);
        short mark = 1;
        grid.setSpace(2, 2, mark);
        grid.setSpace(3, 3, mark);
        grid.setSpace(4, 4, mark);
        SpaceRank result = BoardScanner.scan(x, y, grid, mark);
        assertEquals(false, result.calculateRank());
        assertEquals(4, result.getRank());
    }
}
