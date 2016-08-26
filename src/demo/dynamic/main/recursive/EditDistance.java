package demo.dynamic.main.recursive;


/*

Given two strings str1 and str2 and below operations that can performed on str1. Find minimum number of edits (operations) required to convert ‘str1′ into ‘str2′.

Insert
Remove
Replace
All of the above operations are of equal cost.
 */
public class EditDistance {

    public int getMinOperation(String str1, String str2) {
        return _getMinOperation(str1, str2, str1.length(), str2.length());
    }

    private int _getMinOperation(String str1, String str2, int in, int jn) {

        if (in == 0)
            return jn;

        if (jn == 0)
            return in;

        if (str1.charAt(in - 1) == str2.charAt(jn - 1)) {
            return _getMinOperation(str1, str2, in - 1, jn - 1);
        }

        int remove = _getMinOperation(str1, str2, in - 1, jn);
        int replace = _getMinOperation(str1, str2, in - 1, jn - 1);
        int add = _getMinOperation(str1, str2, in, jn - 1);

        return 1 + min(remove, replace, add);
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
