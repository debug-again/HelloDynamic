package demo.dynamic.main.recursive;

public class CuttingRod {

    public int getMaxPrice(int[] rod, int[] price) {
        return getMaxPrice(rod, price, rod.length, rod[rod.length - 1], 0);
    }

    private int getMaxPrice(int[] rod, int[] price, int n, int len, int totalCost) {

        if (len < 0) return 0;
        if (n == 0 && len >= 0) return 0;
        if (len == 0) return totalCost;

        int inclN = getMaxPrice(rod, price, n, len - rod[n-1], totalCost + price[n-1]);
        int exclN = getMaxPrice(rod, price, n-1, len, totalCost);

        return Integer.max(inclN, exclN);

    }
}
