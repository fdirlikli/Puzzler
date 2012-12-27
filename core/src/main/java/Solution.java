import puzzle.Puzzle;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.commons.lang3.StringUtils;
import puzzle.impl.BrainFuck;

/**
 * Created by IntelliJ IDEA.
 * User: fdirlikl
 * Date: 12/20/12
 * Time: 3:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class Solution
{

    public static void main(String[] args)
    {
        String testString = null;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try
        {
            testString = reader.readLine();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

        Puzzle selectedPuzzle = new BrainFuck(testString,200);
        selectedPuzzle.solve();
        System.out.print(selectedPuzzle.getSolution());
     }

}
