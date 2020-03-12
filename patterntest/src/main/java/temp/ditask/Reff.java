package temp.ditask;

import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.util.Set;

public class Reff {
    public static String getInterfaceImplementation() {
        //Find classes that implement Interface IApple - Scan Package
        //Get package
        Package pack = IApple.class.getPackage();
        System.out.println(pack);
        // Find Interface Implementations
        Reflections reflections = new Reflections(pack);
        Set<Class<? extends IApple>> classes = reflections.getSubTypesOf(IApple.class);
        //https://www.edureka.co/community/11339/retrieve-all-the-implementations-of-an-interface-in-java
        for (Object o : classes) {
            System.out.println(o);
        }
        return classes.toArray()[0].toString().substring(6);
    }

    public static void init() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // Search Package for classes with annotation
        Class<DITest> obj = DITest.class;
        DITest diTest = new DITest();

        for (Field field : obj.getDeclaredFields())
            if (field.isAnnotationPresent(Auto.class)) {
                String className = getInterfaceImplementation();
                Class<?> cls = Class.forName(className);
                field.set(diTest, cls.newInstance());

            }

    }

}

