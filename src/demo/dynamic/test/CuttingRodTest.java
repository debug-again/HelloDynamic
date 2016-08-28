package demo.dynamic.test;

import demo.dynamic.test.performance.PerformanceTest;
import demo.dynamic.test.performance.ReflectedMethod;

public class CuttingRodTest {

    public static void main(String[] args) {

       /* int price[] = {1, 5, 8, 9, 10, 17, 17, 20};
        int rod[] = {1, 2, 3, 4, 5, 6, 7, 8};*/

        int price[] = {1, 5, 8, 9, 10, 17, 17, 20};
        int rod[] = {1, 2, 3, 4, 5, 6, 7, 8};

        int rodLength = rod.length;

        ReflectedMethod rm1 = ReflectedMethod.getBuilderInstance()
                .addClassAndMethod(demo.dynamic.main.recursive.CuttingRod.class, "getMaxPrice")
                .addParamter(rod, int[].class)
                .addParamter(price, int[].class)
                .build();

        ReflectedMethod rm2 = ReflectedMethod.getBuilderInstance()
                .addClassAndMethod(demo.dynamic.main.tabulation.CuttingRod.class, "getMaxPrice")
                .addParamter(rodLength, int.class)
                .addParamter(price, int[].class)
                .build();

        PerformanceTest.compare(rm1, rm2);
    }
}
