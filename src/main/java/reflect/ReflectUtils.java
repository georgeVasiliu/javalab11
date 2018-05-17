package reflect;


import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

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

    public static boolean setTextOnComponent(Object instance, String textToSet) {

        Class<?> cls = instance.getClass();
        String methodName = "setText";
        Method method = null;
        try {
            method = instance.getClass().getMethod(methodName, String.class);
        } catch (Exception e) {
            System.out.println("Method not found.Not able to set text");
            return false;
        }

        if (method != null) {
            method.setAccessible(true);
            try {
                method.invoke(instance, textToSet);
            } catch (Exception e)
            {
                System.out.println("Method call fail");
                e.printStackTrace();
                return false;
            }
        }

        return true;
    }
}
