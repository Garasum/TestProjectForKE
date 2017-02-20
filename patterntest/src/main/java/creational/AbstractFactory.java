package creational;

/**
 * Created by Orest on 2/14/2017.
 */
public class AbstractFactory {

    //Abstract Factory
    public interface IToyFactory {
        Bear GetBear();
        Cat GetCat();
    }

    //Concrete Factory
    public class TeddyToysFactory implements IToyFactory{
        public Bear GetBear() {
            return new TeddyBear();
        }

        public Cat GetCat() {
            return new TeddyCat();
        }
    }

    //Concrete Factory
    public class WoodenToysFactory implements IToyFactory{
        public Bear GetBear() {
            return new WoodenBear();
        }

        public Cat GetCat() {
            return new WoodenCat();
        }
    }

    abstract class AnimalToy {
        protected String name;

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    abstract class Bear extends AnimalToy {
        protected String name;
    }

    abstract class Cat extends AnimalToy {
        protected String name;
    }

    class WoodenCat extends Cat{
        public WoodenCat() {
        }
    }

    class TeddyCat extends Cat{
        public TeddyCat() {
        }
    }

    class WoodenBear extends Bear{
        public WoodenBear() {
        }
    }

    class TeddyBear extends Bear{
        public TeddyBear() {
        }
    }


    public static void main(String[] args) {
        AbstractFactory abstractFactory = new AbstractFactory();
        IToyFactory toyFactory = abstractFactory.new WoodenToysFactory();
        Bear bear = toyFactory.GetBear();
        Cat cat = toyFactory.GetCat();
        System.out.println(bear.getName() + cat.getName());
    }

}
