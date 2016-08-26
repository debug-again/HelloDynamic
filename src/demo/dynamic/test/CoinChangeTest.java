package demo.dynamic.test;

import demo.dynamic.test.performance.PerformanceTest;
import demo.dynamic.test.performance.ReflectedMethod;

public class CoinChangeTest {
    public static void main(String[] args) {

        int[] coins = {3,2,1};
        int sum = 4;

        ReflectedMethod rm1 = ReflectedMethod.getBuilderInstance()
                                            .addClassAndMethod(demo.dynamic.main.recursive.CoinChange.class, "getWays")
                                            .addParamter(coins, int[].class)
                                            .addParamter(sum, int.class)
                                            .build();

        ReflectedMethod rm2 = ReflectedMethod.getBuilderInstance()
                .addClassAndMethod(demo.dynamic.main.tabulation.CoinChange.class, "getWays")
                .addParamter(coins, int[].class)
                .addParamter(sum, int.class)
                .build();

        PerformanceTest.compare(rm1, rm2);
    }
}
