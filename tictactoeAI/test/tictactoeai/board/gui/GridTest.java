package tictactoeai.board.gui;

import java.awt.Graphics;
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
public class GridTest {
    
    public GridTest() {
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
     * Test of addMove method, of class Grid.
     */
    @Test
    public void testAddMoveOutsideClass1() {
        System.out.println("addMove");
        int x = -1;
        int y = -1;
        Grid instance = new Grid();
        instance.addMove(x, y);
        
        assertEquals(instance.getMoves(), 1);
    }
    
    /**
     * Test of addMove method, of class Grid.
     */
    @Test
    public void testAddMoveOnValidSpace() {
        System.out.println("addMove");
        int x = 1;
        int y = 5;
        Grid instance = new Grid();
        instance.addMove(x, y);
        
        assertEquals(instance.getMoves(), 2);
    }
    
    /**
     * Test of addMove method, of class Grid.
     */
    @Test
    public void testAddMoveOutsideClass2() {
        System.out.println("addMove");
        int x = 15;
        int y = 15;
        Grid instance = new Grid();
        instance.addMove(x, y);
        
        assertEquals(instance.getMoves(), 1);
    }
    
    /**
     * Test of addMove method, of class Grid.
     */
    @Test
    public void testAddMoveOnFilledSpace() {
        System.out.println("addMove");
        int x = 7;
        int y = 7;
        Grid instance = new Grid();
        instance.addMove(x, y);
        
        assertEquals(instance.getMoves(), 1);
    }  

    /**
     * Test of reset method, of class Grid.
     */
    @Test
    public void testReset() {
        System.out.println("reset");
        Grid instance = new Grid();
        instance.addMove(0, 0);
        assertEquals(instance.getMoves(), 2);
        instance.reset();
        assertEquals(instance.getMoves(), 1);
    }
    
}
