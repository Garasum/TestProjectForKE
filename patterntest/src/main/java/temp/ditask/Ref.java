package temp.ditask;


import org.testng.internal.reflect.ReflectionHelper;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Ref {

    public static void init() {
        //Find classes that use annotation - Scan Package
        //Find classes that implement Interface IApple - Scan Package
        Class<DITest> obj = DITest.class;

        for (Field field : obj.getDeclaredFields())
            if (field.isAnnotationPresent(Auto.class)) {

                Annotation annotation = field.getAnnotation(Auto.class);
                Auto auto = (Auto) annotation;

                System.out.println("Annotation name value : " + auto);
                System.out.println("Annotation class value : " + auto.getClass());

                try {
                    // use
                    String className = "temp.ditask.Apple";
                    System.out.println(className);
                    Class<?> cls = Class.forName(className);
                    IApple apple = (IApple) cls.newInstance();

                    apple.hello();

                } catch (Throwable ex) {
                    System.out.println(ex);
                }
            }
    }

    public static void findInterfaceImplementation(Class<?> interfaceClass, Package fromPackage) {
        if (interfaceClass == null) {
            System.out.println("unknown subclass");
        }
        if (fromPackage == null) {
            System.out.println("unknown package");
        }


    }

    public void packageLevelAnnotation() throws ClassNotFoundException {
        //Find classes that implement Interface IApple - Scan Package
        //get package
        Package pack = IApple.class.getPackage();
        System.out.println(pack);

        //https://stackoverflow.com/questions/520328/can-you-find-all-classes-in-a-package-using-reflection
        //http://oohhyeah.blogspot.com/2012/01/use-java-reflection-to-find-classes.html
        
        //scan package for classes
            // chack in class - Class<?> cls = searchClass.getInterfaces();
            // if cls implements IApple - return it

    }


    public static void main(String[] args) throws ClassNotFoundException {
        //init();
        String className = "temp.ditask.Apple";
        Class<?> cls = Class.forName(className);

        Ref ref = new Ref();
        ref.packageLevelAnnotation();

        findInterfaceImplementation(cls, cls.getPackage());
    }
}