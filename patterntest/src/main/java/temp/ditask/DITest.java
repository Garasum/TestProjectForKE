package temp.ditask;

public class DITest {

    public static void main(String[] args) {
        @Auto(name = "Apple")
        IApple apple;
        apple.hello();
    }
}
