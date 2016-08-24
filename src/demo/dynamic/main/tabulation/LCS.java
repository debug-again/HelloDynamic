package demo.dynamic.main.tabulation;

public class LCS {

    private int[][] lcsArr;

    public int find(String str1, String str2) {

        lcsArr = new int[str1.length() + 1][str2.length() + 1];
        return _find(str1, str2, str1.length(), str2.length());
    }

    private int _find(String str1, String str2, int iLast, int jLast) {
        for (int i = 0; i <= iLast; i++) {
            for (int j = 0; j <= jLast; j++) {
                if (i == 0 || j == 0) {
                    lcsArr[i][j] = 0;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    lcsArr[i][j] = 1 + lcsArr[i - 1][j - 1];
                } else {
                    lcsArr[i][j] = Integer.max(lcsArr[i][j - 1], lcsArr[i - 1][j]);
                }
            }
        }

        return lcsArr[iLast][jLast];
    }
}
