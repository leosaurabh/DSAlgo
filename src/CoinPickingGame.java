public class CoinPickingGame {

//    Problem statement: Consider a row of n coins of values v1 . . . vn, where n is even. We play
//    a game against an opponent by alternating turns. In each turn, a player selects either the
//    first or last coin from the row, removes it from the row permanently, and receives the value of
//    the coin. Determine the maximum possible amount of money we can definitely win if we move first.
//    F(i, j)  represents the maximum value the user can collect from
//    i'th coin to j'th coin.
//
//    F(i, j)  = Max(Vi + min(F(i+2, j), F(i+1, j-1) ),
//    Vj + min(F(i+1, j-1), F(i, j-2) ))
//    Base Cases
//    F(i, j)  = Vi           If j == i
//    F(i, j)  = max(Vi, Vj)  If j == i+1

    public int optimalStrategyOfGame(int arr[], int i, int j) {
//        int max = Integer.MIN_VALUE;
//        for (int z=i; z<=j; z++) {
//            max = arr[z] > max ? arr[z] : max;
//        }
//        return max;

        return Math.max(arr[i] + Math.min(optimalStrategyOfGame(arr, i+1, j-1), optimalStrategyOfGame(arr, i+2, j)),
                arr[j] + Math.min(optimalStrategyOfGame(arr, i, j-2), optimalStrategyOfGame(arr, i+1, j-1)));
    }
}
