package demo.dynamic.main.recursive;

public class LIS {

    private int result;

    public int find(int[] arr) {
        _lis(arr, arr.length);
        return result;
    }

    private int _lis(int[] arr, int n) {
        if (n == 1) return 1;

        int maxEndingHere = 1;
        for (int i = 1; i < n; i++) {
            int res = _lis(arr, i);
            if (arr[i - 1] < arr[n - 1] && res + 1 > maxEndingHere) {
                maxEndingHere = res + 1;
            }
        }

        if(result < maxEndingHere)
            result = maxEndingHere;

        return maxEndingHere;
    }

}
