package structural;

/**
 * Created by Orest on 3/5/2017.
 * The Proxy pattern allows us to create an intermediary that acts as an interface to another resource,
 * while also hiding the underlying complexity of the component.

When to use the Proxy pattern:
1. When we want a simplified version of a complex or heavy object.
 In this case, we may represent it with a skeleton object which loads the original object on demand,
 also called as lazy initialization.
    This is known as the Virtual Proxy
2. When the original object is present in different address space, and we want to represent it locally.
 We can create a proxy which does all the necessary boilerplate stuff like creating and maintaining
 the connection, encoding, decoding, etc., while the client accesses it as it was present in their local address space.
    This is called the Remote Proxy
3. When we want to add a layer of security to the original underlying object to provide controlled
access based on access rights of the client.
    This is called Protection Proxy
*/
 public class Proxy {

    //Let's now create a simple interface and the configuration for this object:
    public interface ExpensiveObject {
        void process();
    }

    //implementation of this interface with a large initial configuration:

    public class ExpensiveObjectImpl implements ExpensiveObject {

        public ExpensiveObjectImpl() {
            heavyInitialConfiguration();
        }

        @Override
        public void process() {
            System.out.println("processing complete.");
        }

        private void heavyInitialConfiguration() {
            System.out.println("Loading initial configuration...");
        }
    }

    //We'll now utilize the Proxy pattern and initialize our object on demand:

    public class ExpensiveObjectProxy implements ExpensiveObject {
        //private static ExpensiveObject object;
        private ExpensiveObject object;

        @Override
        public void process() {
            if (object == null) {
                object = new ExpensiveObjectImpl();
            }
            object.process();
        }
    }

    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        ExpensiveObject object = proxy.new ExpensiveObjectProxy();
        object.process();
        object.process();
    }
}
