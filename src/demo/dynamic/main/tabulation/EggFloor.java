package demo.dynamic.main.tabulation;


public class EggFloor {

    /**
     * floors ==> Number of floors
     * n ==> Number of Eggs
     */

    public int getMinAttempt(int eggs, int floors) {

        int[][] eggFloor = new int[eggs + 1][floors + 1];

        for (int i = 1; i <= eggs; i++) {
            for (int j = 0; j <= floors; j++) {

                // if one egg total attempt will be floors
                if (i == 1)
                    eggFloor[i][j] = j;
                else if (j == 1 || j == 0)
                    eggFloor[i][j] = j;
                else {

                    int min = Integer.MAX_VALUE;

                    // drop egg in each floor and find the min attempt req
                    for (int k = 1; k <= j; k++) {
                        int res = 1 + Integer.max(eggFloor[i - 1][k - 1], // if breaks
                                eggFloor[i][j - k]);     // if survived remain floors

                        if (res < min) {
                            min = res;
                        }
                    }

                    eggFloor[i][j] = min;
                }
            }
        }

        return eggFloor[eggs][floors];
    }
}
