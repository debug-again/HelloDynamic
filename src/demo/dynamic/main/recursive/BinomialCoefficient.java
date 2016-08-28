package demo.dynamic.main.recursive;

public class BinomialCoefficient {

    // C(n,k) = C(n-1, k-1) + C(n-1, k) ; C(n, 0) = 1; C(n,n) = 1;
    public int getValue(int n, int k) {
        if (k == 0 || k == n)
            return 1;

        return getValue(n - 1, k - 1) + getValue(n - 1, k);
    }
}
