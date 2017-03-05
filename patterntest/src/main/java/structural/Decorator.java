package structural;

/**
 * Created by Orest on 3/5/2017.
 * Decorator pattern allows a user to add new functionality to an existing object without altering its structure.
 * This type of design pattern comes under structural pattern as this pattern acts as a wrapper to existing class.
 * <p>
 * This pattern creates a decorator class which wraps the original class and provides additional functionality keeping class methods signature intact.
 * <p>
 * We are demonstrating the use of decorator pattern via following examp
 */
public class Decorator {

    /**
     * Step 1
     * Create an interface.
     */
    public interface Shape {
        void draw();
    }

    /**
     * Step 2
     * Create concrete classes implementing the same interface.
     */
    public class Rectangle implements Shape {

        @Override
        public void draw() {
            System.out.println("Shape: Rectangle");
        }
    }

    public class Circle implements Shape {

        @Override
        public void draw() {
            System.out.println("Shape: Circle");
        }
    }

    /**
     * Step 3
     * Create abstract decorator class implementing the Shape interface.
     */
    public abstract class ShapeDecorator implements Shape {
        protected Shape decoratedShape;

        public ShapeDecorator(Shape decoratedShape) {
            this.decoratedShape = decoratedShape;
        }

        public void draw() {
            decoratedShape.draw();
        }
    }

    /**
     * Step 4
     * Create concrete decorator class extending the ShapeDecorator class.
     */
    public class RedShapeDecorator extends ShapeDecorator {

        public RedShapeDecorator(Shape decoratedShape) {
            super(decoratedShape);
        }

        @Override
        public void draw() {
            decoratedShape.draw();
            setRedBorder(decoratedShape);
        }

        private void setRedBorder(Shape decoratedShape) {
            System.out.println("Border Color: Red");
        }
    }

    /**
     * Step 5
     * Use the RedShapeDecorator to decorate Shape objects.
     */
    public static void main(String[] args) {
        Decorator decorator = new Decorator();

        Shape circle = decorator.new Circle();

        Shape redCircle  = decorator.new RedShapeDecorator(decorator.new Circle());

        Shape redRectangle = decorator.new RedShapeDecorator(decorator.new Rectangle());

        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nCircle of red border");
        redCircle.draw();

        System.out.println("\nRectangle of red border");
        redRectangle.draw();
    }
}
