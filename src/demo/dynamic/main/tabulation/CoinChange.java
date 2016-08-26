package demo.dynamic.main.tabulation;

public class CoinChange {

    public int getWays(int coins[], int sum) {

        int totalCoins = coins.length;

        int[][] ways = new int[totalCoins + 1][sum + 1];

        // if no coins but sum >= 0 can be done in 0 ways
        for (int i = 0; i <= sum; i++) {
            ways[0][i] = 0;
        }

        // if there are zero sum, dont include any coins, can be done in 1 way
        for (int i = 1; i <= totalCoins; i++) {
            ways[i][0] = 1;
        }


        for (int i = 1; i <= totalCoins; i++) {
            for (int j = 1; j <= sum; j++) {

                ways[i][j] = ways[i - 1][j] ;  // no of ways without without including

                if(j >= i)
                    ways[i][j] += ways[i][j - i];   // no of ways including i coin

            }
        }

        for (int i = 0; i < ways.length; i++) {
            for (int j = 0; j < ways[i].length; j++) {
                System.out.print(ways[i][j] + " ");
            }
            System.out.println();
        }

        return ways[totalCoins][sum];
    }

}
