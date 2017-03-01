package creational;

/**
 * Created by Orest on 2/24/2017.
 */
public class Singleton {

    /** We're going to create a SingleObject class.
     *  SingleObject class have its constructor as private and have a static instance of itself.
     *  SingleObject class provides a static method to get its static instance to outside world. SingletonPatternDemo,
     *  our demo class will use SingleObject class to get a SingleObject object.
     */

    /**
     * Step 1 : Create a Singleton Class.
     */
    public static class SingleObject {
        //create an object of SingleObject
        public static SingleObject instance = new SingleObject();

        //make the constructor private so that this class cannot be
        //instantiated
        private SingleObject() {
        }

        //Get the only object available
        public static SingleObject getInstance() {
            return instance;
        }

        public void showMessage() {
            System.out.println("Hello Singleton");
        }
    }
    /**
     * Step 2 : Get the only object from the singleton class.
     */

    public static void main(String[] args) {

        //illegal construct
        //Compile Time Error: The constructor SingleObject() is not visible
        //SingleObject object = new SingleObject();

        //Get the only object available
        SingleObject object = SingleObject.getInstance();

        object.showMessage();
    }
}
