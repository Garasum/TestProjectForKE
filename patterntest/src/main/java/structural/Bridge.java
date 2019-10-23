package structural;

/**
 * Created by Orest on 3/5/2017.
 * <p>
 * Bridge is used when we need to decouple an abstraction from its implementation so that the two can vary independently.
 * This type of design pattern comes under structural pattern as this pattern decouples implementation class
 * and abstract class by providing a bridge structure between them.
 * <p>
 * This pattern involves an interface which acts as a bridge which makes
 * the functionality of concrete classes independent from interface implementer classes.
 * Both types of classes can be altered structurally without affecting each other.
 */
public class Bridge {
    /**
     * Step 1
     * Create bridge implementer interface.
     */
    public interface DrawAPI {
        public void drawCircle(int radius, int x, int y);
    }

    /**
     * Step 2
     * Create concrete bridge implementer classes implementing the DrawAPI interface.
     */
    public class RedCircle implements DrawAPI {

        @Override
        public void drawCircle(int radius, int x, int y) {
            System.out.println("Drawing Circle[ color: red, radius: " + radius + ", x: " + x + ", " + y + "]");
        }
    }

    public class GreenCircle implements DrawAPI {

        @Override
        public void drawCircle(int radius, int x, int y) {
            System.out.println("Drawing Circle[ color: green, radius: " + radius + ", x: " + x + ", " + y + "]");
        }
    }

    /**
     * Step 3
     * Create an abstract class Shape using the DrawAPI interface.
     */
    public abstract class Shape {
        protected DrawAPI drawAPI;

        protected Shape(DrawAPI drawAPI) {
            this.drawAPI = drawAPI;
        }

        public abstract void draw();
    }

    /**
     * Step 4
     * Create concrete class implementing the Shape interface.
     */
    public class Circle extends Shape {
        private int x, y, radius;

        protected Circle(int x, int y, int radius, DrawAPI drawAPI) {
            super(drawAPI);
            this.x = x;
            this.y = y;
            this.radius = radius;
        }

        @Override
        public void draw() {
            drawAPI.drawCircle(radius, x, y);
        }
    }

    /**
     * Step 5
     * Use the Shape and DrawAPI classes to draw different colored circles.
     */

    public static void main(String[] args) {
        Bridge bridge = new Bridge();
        Shape redCircle = bridge.new Circle(100, 10, 10, bridge.new RedCircle());
        Shape greenCircle = bridge.new Circle(100, 10, 10, bridge.new GreenCircle());

        redCircle.draw();
        greenCircle.draw();
    }

}
