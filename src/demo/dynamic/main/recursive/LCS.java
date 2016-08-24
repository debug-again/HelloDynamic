package demo.dynamic.main.recursive;

public class LCS {

    public int find(String str1, String str2) {

        if (str1.isEmpty() || str2.isEmpty())
            return 0;

        if (str1.charAt(0) == str2.charAt(0))
            return 1 + find(str1.substring(1), str2.substring(1));

        return Integer.max(find(str1, str2.substring(1)), find(str1.substring(1), str2));
    }
}
