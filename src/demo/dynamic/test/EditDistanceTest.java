package demo.dynamic.test;

import demo.dynamic.test.performance.PerformanceTest;
import demo.dynamic.test.performance.ReflectedMethod;

public class EditDistanceTest {
    public static void main(String[] args) {

        String str1 = "qwertyuiopbnm";
        String str2 = "asdfghjklzxcv";

        ReflectedMethod rm1 = ReflectedMethod.getBuilderInstance()
                .addClassAndMethod(demo.dynamic.main.recursive.EditDistance.class, "getMinOperation")
                .addParamter(str1, String.class)
                .addParamter(str2, String.class)
                .build();

        ReflectedMethod rm2 = ReflectedMethod.getBuilderInstance()
                .addClassAndMethod(demo.dynamic.main.tabulation.EditDistance.class, "getMinOperation")
                .addParamter(str1, String.class)
                .addParamter(str2, String.class)
                .build();

        PerformanceTest.compare(rm1, rm2);

    }

}
