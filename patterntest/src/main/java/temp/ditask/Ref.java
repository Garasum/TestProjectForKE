package temp.ditask;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Ref {
    // reflection ?
    // get annotation
    // create object
    // static method init ??

    //https://www.geeksforgeeks.org/method-class-getannotation-method-in-java/
    //https://www.programmingmitra.com/2016/05/creating-objects-through-reflection-in-java-with-example.html
    //https://dzone.com/articles/creating-custom-annotations-in-java
    //https://mkyong.com/java/java-custom-annotations-example/
    //https://javarush.ru/groups/posts/513-reflection-api-refleksija-temnaja-storona-java

    //https://stackoverflow.com/questions/2408789/getting-class-type-from-string
    //https://www.programmingmitra.com/2016/05/creating-objects-through-reflection-in-java-with-example.html

    public static void main(String[] args) {

        Class<DITest> obj = DITest.class;
        //on class level
//        if (obj.isAnnotationPresent(Auto.class)) {
//
//            Annotation annotation = obj.getAnnotation(Auto.class);
//            Auto auto = (Auto) annotation;
//
//            System.out.println("Annotation name value : " + auto.name());
//
//        }

        //TODO : get annotation
        for (Field field : obj.getDeclaredFields()) {
            // if method is annotated with @Auto
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

                    apple.hello();


                }catch (Throwable ex){
                    System.out.println(ex);
                }
                // TODO: how to throw object up ??
            }




        }
    }
}