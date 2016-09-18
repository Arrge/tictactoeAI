
package tictactoeai.AI;
import java.util.Comparator;

/**
 *
 * @author Liekkipipo-pc
 */

public class RankComparator implements Comparator<SpaceRank>
{

    /**
     * compare two ranks
     * @param x SpaceRank
     * @param y SpaceRank
     * @return returns the higher ranked space
     */
    @Override
    public int compare(SpaceRank x, SpaceRank y)
    {
        return y.getRank() - x.getRank();
    }
}
