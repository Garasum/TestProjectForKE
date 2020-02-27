package temp.ditask;

import java.lang.reflect.Field;

public class Reff {
    public static Object init() throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        // TODO : scan DITest for annotation, if present - create object - return/override field
        // Search Package for classes with annotation
        Class<DITest> obj = DITest.class;
        Object returnObject = null;

        for (Field field : obj.getDeclaredFields())
            if (field.isAnnotationPresent(Auto.class)) {
                System.out.println(field);
                System.out.println(field.getName());
                System.out.println(field.getType());
                System.out.println(field.getType().getTypeName());
                System.out.println(field.getType().getName());

                //TODO: Remove hardcoded class - find interface implementation dynamically
                String className = "temp.ditask.Apple";
                Class<?> cls = Class.forName(className);
                //Class<?> cls = Class.forName(field.getType().getName());
                 returnObject = cls.newInstance();
                //field.set(obj,obj);
            }


        return returnObject;
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        init();
    }

}

