package demo.dynamic.main.recursive;

public class CoinChange {

    public int getWays(int[] coins, int sum) {
        return _getWays(coins, coins.length - 1, sum);
    }

    private int _getWays(int[] coins, int m, int sum) {

        if(sum < 0) return 0;   // no soluton exists
        if(m < 0 && sum >= 1)   return 0;   // no coins but sum exists

        if(sum == 0)    return 1;   // dont include any coins

        return _getWays(coins, m-1, sum) + _getWays(coins, m, sum - coins[m]);
    }
}
