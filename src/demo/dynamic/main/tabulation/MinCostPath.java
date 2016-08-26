package demo.dynamic.main.tabulation;

public class MinCostPath {

    private int min(int x, int y, int z) {

        int min = x;
        if (min > y) min = y;
        if (min > z) min = z;

        return min;
    }

    public int getCost(int[][] arr, int iDes, int jDes) {

        int m = arr.length;
        int n = arr[0].length;

        if (iDes < 0 || jDes < 0 || iDes >= m || jDes >= n)
            return -1;

        final int MAX = Integer.MAX_VALUE;

        int[][] dyn = new int[iDes + 2][jDes + 2];

        for (int i = 0; i < iDes + 2; i++) {
            for (int j = 0; j < jDes + 2; j++) {
                if (i == 0 || j == 0) {
                    if (i != j) dyn[i][j] = MAX;
                } else {

                    dyn[i][j] = arr[i - 1][j - 1] + min(
                            dyn[i - 1][j],    //up
                            dyn[i][j - 1],    //left
                            dyn[i - 1][j - 1]   //left-up
                    );
                }
            }
        }


        return dyn[iDes + 1][jDes + 1];
    }
}
