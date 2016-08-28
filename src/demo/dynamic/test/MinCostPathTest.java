package demo.dynamic.test;

import demo.dynamic.test.performance.PerformanceTest;
import demo.dynamic.test.performance.ReflectedMethod;

public class MinCostPathTest {
    public static void main(String[] args) {

        int cost[][] = {{1, 2, 3},
                        {4, 8, 2},
                        {1, 5, 3}};

        int i = 0, j = 1;

        ReflectedMethod rm1 = ReflectedMethod.getBuilderInstance()
                .addClassAndMethod(demo.dynamic.main.tabulation.MinCostPath.class, "getCost")
                .addParamter(cost, cost.getClass())
                .addParamter(i, int.class)
                .addParamter(j, int.class)
                .build();



        PerformanceTest.compare(rm1);
    }
}
