package tictactoeai.AI;

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
@Suite.SuiteClasses({tictactoeai.AI.tools.ToolsSuite.class, tictactoeai.AI.SpaceRankTest.class})
public class AISuite {

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
