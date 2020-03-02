package temp.ditask;

import java.lang.reflect.Field;

public class Reff {
    public static void init() throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        // TODO : scan DITest for annotation, if present - create object - return/override field
        // Search Package for classes with annotation
        Class<DITest> obj = DITest.class;
        DITest diTest = new DITest();


        for (Field field : obj.getDeclaredFields())
            if (field.isAnnotationPresent(Auto.class)) {
                //TODO: Remove hardcoded class - find interface implementation dynamically
                String className = "temp.ditask.Apple";
                Class<?> cls = Class.forName(className);
                field.set(diTest, cls.newInstance());

            }

    }
}

