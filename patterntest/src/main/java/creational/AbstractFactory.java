package creational;

/**
 * Created by Orest on 2/14/2017.
 */
public class AbstractFactory {


    public interface IToyFactory {
        Bear GetBear();

        Cat GetCat();
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

}
