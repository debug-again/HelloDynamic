package demo.dynamic.main.tabulation;

public class BinomialCoefficient {

    // C(n,k) = C(n-1, k-1) + C(n-1, k) ; C(n, 0) = 1; C(n,n) = 1;
    public int getValue(int n, int k) {
       /* if (k == 0 || k == n)
            return 1;

        return getValue(n - 1, k - 1) + getValue(n - 1, k);*/

        int bc[][] = new int[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {

            int end = Integer.min(i, k);
            for (int j = 0; j <= end; j++) {

                if (j == 0 || j == i)
                    bc[i][j] = 1;
                else
                    bc[i][j] = bc[i-1][j-1] + bc[i-1][j];
            }
        }

        return bc[n][k];
    }
}
