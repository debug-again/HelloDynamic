package demo.dynamic.test;


import demo.dynamic.test.performance.PerformanceTest;
import demo.dynamic.test.performance.ReflectedMethod;

public class EggFloor {

    /**
     * k ==> Number of floors
     * n ==> Number of Eggs
     */

    public static void main(String[] args) {

        int n = 2;
        int k = 100;

        ReflectedMethod rm1 = ReflectedMethod.getBuilderInstance()
                .addClassAndMethod(demo.dynamic.main.recursive.EggFloor.class, "getMinAttempt")
                .addParamter(n, int.class)
                .addParamter(k, int.class)
                .build();

        ReflectedMethod rm2 = ReflectedMethod.getBuilderInstance()
                .addClassAndMethod(demo.dynamic.main.tabulation.EggFloor.class, "getMinAttempt")
                .addParamter(n, int.class)
                .addParamter(k, int.class)
                .build();

        PerformanceTest.compare(rm2);
    }
}
