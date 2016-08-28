package demo.dynamic.main.recursive;


public class EggFloor {

    /**
     * k ==> Number of floors
     * n ==> Number of Eggs
     */

    public int getMinAttempt(int n, int k) {

        // if one egg total attempt will be k
        if (n == 1) return k;

        // if no floors or one floor
        if (k == 1 || k == 0) return k;

        // drop egg in each floor and find the min attempt req

        int min = Integer.MAX_VALUE;

        // calculate min ops req of max attempt in each floor
        for (int i = 1; i <= k; i++) {
            int res = Integer.max(getMinAttempt(n - 1, i-1), // if breaks
                    getMinAttempt(n, k - i));     // if survived

            if(res < min){
                min = res;
            }
        }

        return 1 + min;
    }
}
