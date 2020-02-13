package temp.exeptino;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Exeptino {
    public static int getAreaValue(int x, int y) {
        if (x < 0 || y < 0)
            throw new IllegalArgumentException("value of 'x' or 'y' is negative: x=" + x + ", y=" + y);
        return x * y;
    }
}

class MyException extends Exception {
    public MyException(Throwable e) {
        initCause(e);
    }
}

class NewClass {
    public static void main(String[] args) throws MyException {
        int result = 0;

        try {
            result = Exeptino.getAreaValue(-1, 100);
        } catch (IllegalArgumentException e) {
            Logger.getLogger(NewClass.class.getName()).log(Level.WARNING, "Negative Argument");
            throw new MyException(e);
        }
        System.out.println("Result:" + result);

    }
}



