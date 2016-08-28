package demo.dynamic.main.recursive;

public class LongestPalindromicSubsequence {

    public int find(String str) {

        return _find(str, 0, str.length() - 1);
    }

    private int _find(String str, int i, int j) {

        if (i > j) return 0;

        if (i == j) return 1;

        if (str.charAt(i) == str.charAt(j))
            return 2 + _find(str, i + 1, j - 1);

        return Integer.max(  _find(str, i + 1, j), _find(str, i + 1, j - 1) );
    }
}
