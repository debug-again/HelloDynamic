package demo.dynamic.main.recursive;

public class KnapSnack {

    private int max(int a, int b) {
        return a > b ? a : b;
    }

    public int getMaxWeight(int[] wt, int val[], int w) {
        return _getMaxWeight(wt, val, w, wt.length);
    }

    private int _getMaxWeight(int[] wt, int[] val, int w, int n) {

        if (n <= 0) return 0;
        if (w <= 0) return 0;

        if (wt[n - 1] > w) {
            return _getMaxWeight(wt, val, w, n - 1);
        }

        return max(
                val[n - 1] + _getMaxWeight(wt, val, w - wt[n - 1], n - 1),   // including wt n
                _getMaxWeight(wt, val, w, n - 1)  //excluding wt n
        );

    }
}
