package tictactoeai;

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
@Suite.SuiteClasses({tictactoeai.board.BoardSuite.class, tictactoeai.AI.AISuite.class, tictactoeai.TictactoeAITest.class})
public class TictactoeaiSuite {

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
