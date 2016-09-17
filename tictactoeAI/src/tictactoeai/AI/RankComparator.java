
package tictactoeai.AI;
import java.util.Comparator;

/**
 *
 * @author Liekkipipo-pc
 */

public class RankComparator implements Comparator<SpaceRank>
{
    @Override
    public int compare(SpaceRank x, SpaceRank y)
    {
        return y.getRank() - x.getRank();
    }
}
