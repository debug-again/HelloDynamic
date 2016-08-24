package demo.dynamic.main.memoization;

import java.util.Arrays;

public class LCS {

    private int[][] arr;

    public int find(String str1, String str2) {

        arr = new int[str1.length()][str2.length()];
        for (int i = 0; i < str1.length(); i++)
            Arrays.fill(arr[i], -1);

        return _find(str1, str2, str1.length() - 1, str2.length() - 1);
    }

    private int _find(String str1, String str2, int i1, int i2) {

        if (str1.length() == 0 || str2.length() == 0)
            return 0;

        if (arr[i1][i2] != -1)
            return arr[i1][i2];

        if (str1.charAt(i1) == str2.charAt(i2))
            arr[i1][i2] = 1 + _find(str1.substring(0, i1), str2.substring(0, i2), i1 - 1, i2 - 1);

        else
            arr[i1][i2] = Integer.max(_find(str1, str2.substring(0, i2 ), i1, i2 - 1), _find(str1.substring(0, i1), str2, i1 - 1, i2));

        return arr[i1][i2];
    }
}
