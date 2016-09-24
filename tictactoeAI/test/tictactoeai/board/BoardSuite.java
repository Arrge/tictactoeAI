package tictactoeai.board;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Liekkipipo-pc
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({tictactoeai.board.gui.GuiSuite.class, tictactoeai.board.GridValuesTest.class})
public class BoardSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
