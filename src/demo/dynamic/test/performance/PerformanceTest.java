package demo.dynamic.test.performance;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.*;

public class PerformanceTest {

    public static void compare(ReflectedMethod... rms) {

        List<Method> methodList = new ArrayList<>();
        List<Object> instanceList = new ArrayList<>();
        List<Object[]> valuesList = new ArrayList<>();

        for (ReflectedMethod rm : rms) {
            Class clazz = rm.getClazz();
            String methodName = rm.getMethodName();
            Object[] values = rm.getParams();
            Class[] types = rm.getTypes();

            try {
                Method method = clazz.getDeclaredMethod(methodName, types);
                Object object = clazz.newInstance();

                methodList.add(method);
                instanceList.add(object);
                valuesList.add(values);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        List<Long> executionTime = new ArrayList<>();
        Map<Long, String> map = new HashMap<>();

        for (int i = 0; i < instanceList.size(); i++) {

            Method method = methodList.get(i);
            Object instance = instanceList.get(i);
            Object[] values = valuesList.get(i);
            Object result = null;

            long t1 = System.nanoTime();
            try {
                result = method.invoke(instance, values);
            } catch (Exception e) {
                e.printStackTrace();
            }
            long t2 = System.nanoTime();
            long timeTaken = (t2 - t1);

            String summary = "Class : " + instance.getClass().getName() + ", Method : " + method.getName() + ", Result : " + result + ", Time : " + (t2 - t1) + "ns";

            while (map.containsKey(timeTaken)) {
                timeTaken++;
            }

            executionTime.add(timeTaken);
            map.put(timeTaken, summary);
        }

        BigDecimal sum = new BigDecimal(0);
        for (Long time : executionTime) {
            sum = sum.add(new BigDecimal(time));
        }

        Collections.sort(executionTime);

        for(Long time : executionTime){
            String summary = map.get(time);
            System.out.println(summary + ", Consumption : " + new BigDecimal(time * 100).divide(sum, MathContext.DECIMAL32) + "%");
        }
    }
}
