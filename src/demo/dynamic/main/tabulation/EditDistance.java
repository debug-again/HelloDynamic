package demo.dynamic.main.tabulation;

public class EditDistance {

    public int getMinOperation(String str1, String str2) {

        int[][] dyn = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 0; i < dyn.length; i++) {
            for (int j = 0; j < dyn[i].length; j++) {

                // if Str1 is empty, add all from str2
                if (i == 0)
                    dyn[i][j] = j;

                    // if str2 is empty, remove all from str1
                else if (j == 0)
                    dyn[i][j] = i;

                    // if last char of both match
                else if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    dyn[i][j] = dyn[i - 1][j - 1];

                else
                    dyn[i][j] = 1 + min(
                            dyn[i - 1][j - 1],   // replace
                            dyn[i][j - 1],       // add
                            dyn[i - 1][j]        // remove
                    );
            }
        }

        return dyn[str1.length()][str2.length()];
    }

    private int min(int i, int j, int k) {
        int min = i;

        if (min > j)
            min = j;

        if (min > k)
            min = k;

        return min;
    }
}
