package behavioral;

/**
 * This pattern is used to get a way to access the elements of a collection object
 * in sequential manner without any need to know its underlying representation.
 */

public class Iteratorr {

    //Create interfaces.
    public interface Iterator {
        public boolean hasNext();

        public Object next();
    }

    public interface Container {
        public Iterator getIterator();
    }

    //Create concrete class implementing the Container interface.
    // This class has inner class NameIterator implementing the Iterator interface.
    public class NameRepository implements Container {
        public String names[] = {"Robert", "John", "Julie", "Lora"};

        @Override
        public Iterator getIterator() {
            return new NameIterator();
        }

        private class NameIterator implements Iterator {

            int index;

            @Override
            public boolean hasNext() {

                if (index < names.length) {
                    return true;
                }
                return false;
            }

            @Override
            public Object next() {

                if (this.hasNext()) {
                    return names[index++];
                }
                return null;
            }
        }
    }

    public static void main(String[] args) {
        Iteratorr i = new Iteratorr();
        NameRepository namesRepository = i.new NameRepository();

        for (Iterator iter = namesRepository.getIterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            System.out.println("Name : " + name);
        }
    }

}
