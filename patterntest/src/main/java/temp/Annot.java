package temp;

import java.lang.reflect.Method;

public class Annot {

    @My(str = "Annotation", val = 100)
    public static void myMeth(){
        System.out.println("Annotation");
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Annot.myMeth();
        Annot annot = new Annot();
        annot.myMeth();
        Class<?> c = annot.getClass();
        Method m = c.getMethod("myMeth");
        My anno = m.getAnnotation(My.class);

        System.out.println(anno);
    }



}
