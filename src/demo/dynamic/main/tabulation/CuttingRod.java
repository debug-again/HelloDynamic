package demo.dynamic.main.tabulation;

public class CuttingRod {

    private int max(int x, int y) {
        return x > y ? x : y;
    }

    public int getMaxPrice(int rodLength, int[] price) {

        int[] sum = new int[rodLength + 1];

        for (int i = 1; i <= rodLength; i++) {
            for (int j = i; j <= rodLength; j++) {
                sum[j] = max(price[i - 1] + sum[j - i], /*including*/   sum[j]  /*excluding*/);
            }
        }

        //System.out.println(Arrays.toString(sum));

        return sum[rodLength];
    }
}
