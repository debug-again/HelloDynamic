package demo.dynamic.test;

import demo.dynamic.test.performance.PerformanceTest;
import demo.dynamic.test.performance.ReflectedMethod;

public class LCSTest {
    public static void main(String[] args) {

        String str1 = "AGGTAB";
        String str2 = "GXTXAYB";

        ReflectedMethod rm1 = ReflectedMethod.getBuilderInstance()
                .addClassAndMethod(demo.dynamic.main.recursive.LCS.class, "find")
                .addParamter(str1, String.class)
                .addParamter(str2, String.class)
                .build();

        ReflectedMethod rm2 = ReflectedMethod.getBuilderInstance()
                .addClassAndMethod(demo.dynamic.main.memoization.LCS.class, "find")
                .addParamter(str1, String.class)
                .addParamter(str2, String.class)
                .build();

        ReflectedMethod rm3 = ReflectedMethod.getBuilderInstance()
                .addClassAndMethod(demo.dynamic.main.tabulation.LCS.class, "find")
                .addParamter(str1, String.class)
                .addParamter(str2, String.class)
                .build();

        PerformanceTest.compare(rm1, rm2, rm3);
    }
}
