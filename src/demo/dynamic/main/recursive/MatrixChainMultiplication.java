package demo.dynamic.main.recursive;

public class MatrixChainMultiplication {

    public static void main(String[] args) {

        int p[] = {40, 20, 30, 10, 30};
        int res = getMinOperation(p, 1, p.length - 1);
        System.out.println("res = " + res);

    }

    private static int getMinOperation(int[] p, int s, int e) {

        if (s == e)
            return 0;

        int min = Integer.MAX_VALUE;

        for (int i = s; i < e; i++) {

            System.out.println(s + " "  + e);
            int count = getMinOperation(p, s, i) + getMinOperation(p, i + 1, e) + p[s - 1] * p[i] * p[e];
            if (count < min) {
                min = count;
            }
        }

        return min;
    }

}
