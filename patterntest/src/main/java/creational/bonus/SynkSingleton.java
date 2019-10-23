package creational.bonus;

// https://habr.com/ru/post/129494/
public class SynkSingleton {

    private static SynkSingleton instance;

    public static synchronized SynkSingleton getInstance() {
        if (instance == null) {
            instance = new SynkSingleton();
        }
        return instance;
    }

}
