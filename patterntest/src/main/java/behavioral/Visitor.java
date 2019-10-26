package behavioral;

/**
 * In Visitor pattern, we use a visitor class which changes the executing algorithm of an element class.
 * By this way, execution algorithm of element can vary as and when visitor varies.
 */
public class Visitor {

    //Define an interface to represent element.
    public interface ComputerPart {
        public void accept(ComputerPartVisitor computerPartVisitor);
    }

    //Create concrete classes extending the above class.
    public class Keyboard implements ComputerPart {

        @Override
        public void accept(ComputerPartVisitor computerPartVisitor) {
            computerPartVisitor.visit(this);
        }
    }

    public class Monitor implements ComputerPart {

        @Override
        public void accept(ComputerPartVisitor computerPartVisitor) {
            computerPartVisitor.visit(this);
        }
    }

    public class Mouse implements ComputerPart {

        @Override
        public void accept(ComputerPartVisitor computerPartVisitor) {
            computerPartVisitor.visit(this);
        }
    }

    public class Computer implements ComputerPart {

        ComputerPart[] parts;

        public Computer() {
            parts = new ComputerPart[]{new Mouse(), new Keyboard(), new Monitor()};
        }

        @Override
        public void accept(ComputerPartVisitor computerPartVisitor) {
            for (int i = 0; i < parts.length; i++) {
                parts[i].accept(computerPartVisitor);
            }
            computerPartVisitor.visit(this);
        }
    }

    //Define an interface to represent visitor.
    public interface ComputerPartVisitor {
        public void visit(Computer computer);

        public void visit(Mouse mouse);

        public void visit(Keyboard keyboard);

        public void visit(Monitor monitor);
    }

    //Create concrete visitor implementing the above class.
    public class ComputerPartDisplayVisitor implements ComputerPartVisitor {

        @Override
        public void visit(Computer computer) {
            System.out.println("Displaying Computer.");
        }

        @Override
        public void visit(Mouse mouse) {
            System.out.println("Displaying Mouse.");
        }

        @Override
        public void visit(Keyboard keyboard) {
            System.out.println("Displaying Keyboard.");
        }

        @Override
        public void visit(Monitor monitor) {
            System.out.println("Displaying Monitor.");
        }
    }

    public static void main(String[] args) {
        Visitor v = new Visitor();

        ComputerPart computer = v.new Computer();
        computer.accept(v.new ComputerPartDisplayVisitor());
    }
}
