package demo.dynamic.test;

import demo.dynamic.test.performance.PerformanceTest;
import demo.dynamic.test.performance.ReflectedMethod;

public class KnapSnackTest {

    public static void main(String[] args) {

        int val[] = {60, 100, 120};
        int wt[] = {10, 20, 30};
        int  w = 20;

        ReflectedMethod rm1 = ReflectedMethod.getBuilderInstance()
                .addClassAndMethod(demo.dynamic.main.recursive.KnapSnack.class, "getMaxWeight")
                .addParamter(wt, int[].class)
                .addParamter(val, int[].class)
                .addParamter(w, int.class)
                .build();

        PerformanceTest.compare(rm1);
    }
}
