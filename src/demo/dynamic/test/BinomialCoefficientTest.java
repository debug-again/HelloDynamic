package demo.dynamic.test;

import demo.dynamic.test.performance.PerformanceTest;
import demo.dynamic.test.performance.ReflectedMethod;

public class BinomialCoefficientTest {
    public static void main(String[] args) {

        int n = 5, k =2;
        ReflectedMethod rm1 = ReflectedMethod.getBuilderInstance()
                .addClassAndMethod(demo.dynamic.main.recursive.BinomialCoefficient.class, "getValue")
                .addParamter(n, int.class)
                .addParamter(k, int.class)
                .build();

        ReflectedMethod rm2 = ReflectedMethod.getBuilderInstance()
                .addClassAndMethod(demo.dynamic.main.tabulation.BinomialCoefficient.class, "getValue")
                .addParamter(n, int.class)
                .addParamter(k, int.class)
                .build();


        PerformanceTest.compare(rm1, rm2);
    }
}
