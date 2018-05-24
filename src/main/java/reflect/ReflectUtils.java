package reflect;


import javax.swing.*;
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

    public static Object[] getProps(JComponent comp) {
        Object[] props = new Object[4];
        Class<?> cls = comp.getClass();
        String[] propsNames = {"getX", "getY", "getText"};
        Method method = null;
        props[0] = cls.getSimpleName();

        for (int i = 1; i < 4; i++)
            try {
                method = cls.getMethod(propsNames[i - 1]);
                if (method != null) {
                    try {
                        method.setAccessible(true);
                        if (i == 3)
                            props[i] = (String) method.invoke(comp);
                        else {
                            props[i] = (Integer) method.invoke(comp);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (NoSuchMethodException e) {
                System.out.println("No such method");
            }

        return props;
    }
}
