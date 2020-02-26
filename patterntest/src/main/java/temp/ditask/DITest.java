package temp.ditask;

import static temp.ditask.Ref.init;

public class DITest {

    @Auto(name = "Apple")
    IApple apple;

    public static void main(String[] args) {
        init();
        //apple.hello();
    }

}
