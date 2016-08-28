package demo.dynamic.test;

import demo.dynamic.test.performance.PerformanceTest;
import demo.dynamic.test.performance.ReflectedMethod;

public class LPSTest {
    public static void main(String[] args) {

        String str = "BB";

        ReflectedMethod rm2 = ReflectedMethod.getBuilderInstance()
                .addClassAndMethod(demo.dynamic.main.recursive.LongestPalindromicSubsequence.class, "find")
                .addParamter(str, String.class)
                .build();

        PerformanceTest.compare(rm2);
    }
}
