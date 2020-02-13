package temp;

public class GenericTry {
    public static void main(String[] args) {
//        BoxPrinter value1 = new BoxPrinter(new Integer(10));
//        System.out.println(value1);
//        Integer intValue1 = (Integer) value1.getValue();
//
//        BoxPrinter value2 = new BoxPrinter("Hello World");
//        System.out.println(value2);
        // Here we have an error
        // java.lang.String cannot be cast to java.lang.Integer
        //Integer intValue2 = (Integer) value2.getValue();


        BoxPrinter<Integer> value1 = new BoxPrinter<Integer>(new Integer(10));
        System.out.println(value1);
        Integer intValue1 = value1.getValue();
        BoxPrinter<String> value2 = new BoxPrinter<String>("Hello world");
        System.out.println(value2);

        // Repeat Error
        //compilation problem:
        //    Type mismatch: cannot convert from String to Integer
        //Integer intValue2 = value2.getValue();
        String intValue2 = value2.getValue();
    }
}

class BoxPrinter<T> {
    private T val;

    public BoxPrinter(T arg) {
        val = arg;
    }

    public String toString() {
        return "{" + val + "}";
    }

    public T getValue() {
        return val;
    }
}


