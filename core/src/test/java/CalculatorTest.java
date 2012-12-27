import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import puzzle.Puzzle;
import puzzle.impl.BrainFuck;


/**
 * Created by IntelliJ IDEA.
 * User: fdirlikl
 * Date: 12/20/12
 * Time: 5:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class CalculatorTest {
    Puzzle testPuzzle;

    @Before
    public void instantiatePuzzle()
    {
        testPuzzle = new BrainFuck("++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++.>+.+++++++..+++.>++.<<+++++++++++++" +
                "++.>.+++.------.--------.>+.>.",200);
    }

    @Test
    public void testSolvePuzzle()
    {
        testPuzzle.solve();
        System.out.print(testPuzzle.getSolution());
        assertEquals("Hello World!", StringUtils.trim(testPuzzle.getSolution()));
    }

    @Before
    public void instantiatePuzzleFailure()
    {
        testPuzzle = new BrainFuck("++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++.>+.+++++++..+++.>++.<<+++++++++++++" +
                "++.>.+++.------.--------.>+.>.",200);
    }

    @Test(expected = RuntimeException.class)
    public void testAskSolutionBeforeSolve()
    {
        String testSolution = testPuzzle.getSolution();
        assertNotNull("getSolution returned null because it was called before solve method",testSolution);
    }
}
