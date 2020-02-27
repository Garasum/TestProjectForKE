package temp.ditask;

import static temp.ditask.Reff.init;

public class DITest {

    @Auto(name = "Apple")
    IApple apple;

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        init();
        //apple.hello();
    }

}
