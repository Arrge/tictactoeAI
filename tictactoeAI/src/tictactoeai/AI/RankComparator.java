
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
        //x > y = positive return value
        if (x.isForcedMove() - y.isForcedMove() == 0) {
            if (x.isWinningMove() - y.isWinningMove() == 0)  {
                if (x.isEnemyWinningMove() - y.isEnemyWinningMove() == 0) {
                    return y.getTotalRank() - x.getTotalRank();
                }
                else {
                    return y.isEnemyWinningMove() - x.isEnemyWinningMove();
                }
            }
            else {
                return y.isWinningMove() - x.isWinningMove();
            }
        }
        else {
            return y.isForcedMove() - x.isForcedMove();
        }
        
    }
}
