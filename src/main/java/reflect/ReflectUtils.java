package reflect;

import java.lang.reflect.Constructor;

public class ReflectUtils {

    public static Object getInstanceOf(String className, Object[] constructorArguments, Class<?>... constructorTypes) throws Exception {
        Class<?> targetClass = Class.forName(className);
        Constructor<?> targetConstructor = targetClass.getConstructor(constructorTypes);
        return targetConstructor.newInstance(constructorArguments);
    }

    public static Object getInstanceOf(String className) throws Exception {
        Class<?> targetClass = Class.forName(className);
        return targetClass.getDeclaredConstructor().newInstance();
    }
}
