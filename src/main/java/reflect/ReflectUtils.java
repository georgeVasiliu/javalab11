package reflect;


import javax.swing.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Locale;

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

    public static void setInstanceText(JComponent comp, String text) throws Exception
    {

        System.out.println("Loading for " + comp.getName());
        Class<?> c = Class.forName(comp.getName());
        Object t = c.newInstance();
        Method[] methods = comp.getClass().getMethods();
        for (Method m :methods)
        {
            if (m.getName().equalsIgnoreCase("setText"))
            {
                m.setAccessible(true);
                Object object = m.invoke(t,text);
            }
        }
    }
}
