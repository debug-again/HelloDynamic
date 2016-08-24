package demo.dynamic.test.performance;

import java.util.ArrayList;
import java.util.List;

public class ReflectedMethod {

    private Class clazz;
    private String methodName;
    private Object[] params;
    private Class[] types;

    private ReflectedMethod() {
    }

    public static ReflectionBuilder getBuilderInstance() {
        return new ReflectionBuilder();
    }

    public Class getClazz() {
        return clazz;
    }

    public String getMethodName() {
        return methodName;
    }

    public Object[] getParams() {
        return params;
    }

    public Class[] getTypes() {
        return types;
    }

    public static class ReflectionBuilder {

        private Class clazz;
        private String method;
        private List<Object> params = new ArrayList<>();
        private List<Class> types = new ArrayList<>();

        private ReflectionBuilder() {
        }

        public ReflectionBuilder addClassAndMethod(Class clazz, String method) {
            this.clazz = clazz;
            this.method = method;
            return this;
        }

        public ReflectionBuilder addParamter(Object param, Class type) {
            params.add(param);
            types.add(type);
            return this;
        }

        public ReflectedMethod build() {

            ReflectedMethod reflectedMethod = new ReflectedMethod();

            if (this.params.isEmpty()) {
                reflectedMethod.params = null;
            } else {
                reflectedMethod.params = params.toArray();
            }

            if (this.types.isEmpty()) {
                reflectedMethod.types = null;
            } else {
                Class[] classes = new Class[types.size()];
                reflectedMethod.types = types.toArray(classes);
            }

            reflectedMethod.clazz = this.clazz;
            reflectedMethod.methodName = this.method;

            return reflectedMethod;
        }

    }

}
