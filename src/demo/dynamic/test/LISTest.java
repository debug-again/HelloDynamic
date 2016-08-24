package demo.dynamic.test;

import demo.dynamic.test.performance.PerformanceTest;
import demo.dynamic.test.performance.ReflectedMethod;

public class LISTest {

    public static void main(String[] args) {
        int arr[] = {10, 22, 5, 6, 30, 7, 9};

        ReflectedMethod rm1 = ReflectedMethod.getBuilderInstance()
                .addClassAndMethod(demo.dynamic.main.recursive.LIS.class, "find")
                .addParamter(arr, int[].class)
                .build();

        ReflectedMethod rm2 = ReflectedMethod.getBuilderInstance()
                .addClassAndMethod(demo.dynamic.main.memoization.LIS.class, "find")
                .addParamter(arr, int[].class)
                .build();

        PerformanceTest.compare(rm1, rm2);
    }
}
