package temp.ditask;

import static temp.ditask.Reff.init;

public class DITest {

    @Auto
    static IApple apple;

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        init();
        apple.hello();
    }

}
