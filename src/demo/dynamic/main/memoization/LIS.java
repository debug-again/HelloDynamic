package demo.dynamic.main.memoization;


public class LIS {

    private int lis[];
    private int max = 1;

    public int find(int[] arr) {

        lis = new int[arr.length];
        lis[0] = 1;
        _lis(arr, arr.length - 1);
        return max;
    }

    private int _lis(int[] arr, int index) {

        if (lis[index] > 0) return lis[index];
        int max_ending_here = 1;

        for (int i = 0; i < index; i++) {
            int res = _lis(arr, i);
            if (arr[i] < arr[index] && res + 1 > max_ending_here) {
                max_ending_here = res + 1;
            }
        }

        if(max < max_ending_here)
            max = max_ending_here;

        lis[index] = max_ending_here;
        return lis[index];
    }
}