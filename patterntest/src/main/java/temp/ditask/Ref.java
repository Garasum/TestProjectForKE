package temp.ditask;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Ref {
    // reflection ?
    // get annotation
    // create object
    // static method init ??
    // HOW TO GET CREATED OBJECT ???

    //https://www.geeksforgeeks.org/method-class-getannotation-method-in-java/
    //https://www.programmingmitra.com/2016/05/creating-objects-through-reflection-in-java-with-example.html
    //https://dzone.com/articles/creating-custom-annotations-in-java
    //https://mkyong.com/java/java-custom-annotations-example/
    //https://javarush.ru/groups/posts/513-reflection-api-refleksija-temnaja-storona-java

    //https://stackoverflow.com/questions/2408789/getting-class-type-from-string
    //https://www.programmingmitra.com/2016/05/creating-objects-through-reflection-in-java-with-example.html

    //public static void main(String[] args) {

    public static void init() {
        //https://marcin-chwedczuk.github.io/creating-and-using-adnotations-in-java
        Class<DITest> obj = DITest.class;
        //IApple apple;

        //TODO : get annotation
        // if method is annotated with @Auto
        for (Field field : obj.getDeclaredFields())
            if (field.isAnnotationPresent(Auto.class)) {

                Annotation annotation = field.getAnnotation(Auto.class);
                Auto auto = (Auto) annotation;

                System.out.println("Annotation name value : " + auto.name());

                // TODO: if auto.name implements IApple -> Create new object ( invoke(obj.newInstance() )
                try {
                    //method.invoke(obj.newInstance());
                    String className = "temp.ditask." + auto.name();
                    System.out.println(className);
                    Class<?> cls = Class.forName(className);
                    //cls.newInstance();
                    IApple apple = (IApple) cls.newInstance();
                    //apple = (IApple) cls.newInstance();

                    apple.hello();
                    //Invoking Methods by Name
                    //https://www.oracle.com/technical-resources/articles/java/javareflection.html

                    //if (field.isAnnotationPresent(Auto.class))
                    // return object

                } catch (Throwable ex) {
                    System.out.println(ex);
                }
                // TODO: how to throw object up ??
            }
    }
}